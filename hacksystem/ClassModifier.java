package hacksystem;

/**
 * @author leon on 2018/7/10.
 * @version 1.0
 */

public class ClassModifier
{
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;
    private static final int CONSTANT_UTF8_INFO = 1;
    //相应tag的常量池中的数据结构对应的字节数，-1表示扫描常量池时不使用该tag的长度
    private static final int[] CONSTANT_ITEM_LENGTH = {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};
    private static final int u1 = 1;
    private static final int u2 = 2;
    private byte[] classBytes;
    public ClassModifier(byte[] classBytes){
        this.classBytes = classBytes;
    }
    public byte[] modifyUTF8Constant(String oldStr,String newString){
        byte[] newBytes = classBytes;
        //读取常量池长度
        int len = BytesUtil.bytes2Int(classBytes, CONSTANT_POOL_COUNT_INDEX, u2);
        int index = CONSTANT_POOL_COUNT_INDEX+u2;
        for (int i = 0; i < len; i++)
        {
            int tag = BytesUtil.bytes2Int(classBytes, index, u1);

            if(tag == CONSTANT_UTF8_INFO) //是UTF-8类型变量
            {
                int oldStringLength = BytesUtil.bytes2Int(classBytes, index+u1, u2);
                String content = BytesUtil.bytes2String(classBytes, index+3, oldStringLength);
                System.out.println("utf8常量:"+content);
                if(content.equalsIgnoreCase(oldStr))
                {
                    //发现目标
                    //新字符串字节
                    byte[] newStringBytes = BytesUtil.string2Bytes(newString);
                    //新字符串长度字节
                    byte[] newLengthBytes = BytesUtil.int2Bytes(newStringBytes.length, u2);
                    //替换长度
                    newBytes = BytesUtil.replaceBytes(classBytes, index+1,2, newLengthBytes);
                    //替换字符串
                    newBytes = BytesUtil.replaceBytes(newBytes, index+3,oldStringLength, newStringBytes);
                    break;
                }
                index += (3+oldStringLength);
            }else {
                //其他类型常量，直接跳过
                index+=CONSTANT_ITEM_LENGTH[tag];
            }
        }
        //如果没找到目标字符串，直接返回原始字节数组
        return newBytes;
    }
}
