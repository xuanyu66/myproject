package hacksystem; /**
 * @author leon on 2018/7/10.
 * @version 1.0
 */
import java.io.UnsupportedEncodingException;

import javax.xml.stream.events.StartDocument;

public class BytesUtil
{
    /**
     *
     * @param b 字节数组高位在前,第0个字节是最高位字节
     * @param start
     * @param len
     * @return
     */
    public static int bytes2Int(byte[] b, int start, int len)
    {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++)
        {
            // 字节转无符号整数
            int n = ((int) b[i]) & 0xff;
            // 考虑到一个字节八位，将高位字节的值左移 右侧字节个数*8位
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    /**
     * 将value用len长度的字节数组表示,要求value为无符号整数,字节数组高位在前
     * @param value
     * @param len
     * @return
     */
    public static byte[] int2Bytes(int value,int len) {
        byte[] b = new byte[len];
        for (int i = 0; i < len; i++)
        {
            //从低位到高位填充字节数组
            //只考虑无符号情况，不考虑value为负
            b[len-1-i] = (byte) (value >>> (8*i));
        }
        return b;
    }
    /**
     * 返回字节数组UTF-8解码后的字符串
     * @param b
     * @param start
     * @param len
     * @return
     */
    public static String bytes2String(byte[] b,int start,int len)
    {
        try
        {
            return new String(b,start,len,"UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    /**
     *
     * @param string
     * @return
     */
    public static byte[] string2Bytes(String string)
    {
        try
        {
            return string.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 用给定的字节数组替换指定字节数组中的部分字节
     * @param src
     * @param offset
     * @param length
     * @param replaceBytes
     * @return
     */
    public static byte[] replaceBytes(byte[] src,int offset,int length,byte[] replaceBytes)
    {
        //计算替换后长度，建立新数组
        byte[] newBytes = new byte[src.length-length+replaceBytes.length];
        //前
        System.arraycopy(src, 0, newBytes, 0, offset);
        //中
        System.arraycopy(replaceBytes,0,newBytes,offset, replaceBytes.length);
        //后
        System.arraycopy(src, offset+length, newBytes, offset+replaceBytes.length,src.length-offset-length);
        return newBytes;
    }
}