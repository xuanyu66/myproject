package hacksystem;

/**
 * @author leon on 2018/7/10.
 * @version 1.0
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main
{
    public static void main(String[] args)
    {
        //System.out.println("第一行");
        //System.out.println("第二行");
        //System.out.println("第三行");
        try{
            exec();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void exec() throws IOException
    {
        InputStream inputStream = new FileInputStream("E:/sort.class");
        byte[] classBytes = new byte[inputStream.available()];
        inputStream.read(classBytes);
        inputStream.close();
        //偷梁换柱
        ClassModifier classModifier = new ClassModifier(classBytes);
        classBytes = classModifier.modifyUTF8Constant("java/lang/System","hacksystem/HackSystem");
        //输出查看
        OutputStream outputStream = new FileOutputStream("E:/Main2.class");
        outputStream.write(classBytes);
        outputStream.flush();
        outputStream.close();
        //
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.loadByte(classBytes);
        try
        {
            Method method = clazz.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        } catch (NoSuchMethodException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}