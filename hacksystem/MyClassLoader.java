package hacksystem;

/**
 * @author leon on 2018/7/10.
 * @version 1.0
 */
public class MyClassLoader extends ClassLoader
{
    public MyClassLoader()
    {
        super(MyClassLoader.class.getClassLoader());
    }
    public Class loadByte(byte[] classBytes)
    {
        return defineClass(null,classBytes, 0,classBytes.length);
    }
}
