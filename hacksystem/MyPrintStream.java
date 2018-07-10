package hacksystem;

/**
 * @author leon on 2018/7/10.
 * @version 1.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class MyPrintStream extends PrintStream
{
    int i = 0;
    public MyPrintStream(File file) throws FileNotFoundException
    {
        super(file);
    }
    @Override
    public void println(String string)
    {
        super.println((++i)+"."+string);
    }
}
