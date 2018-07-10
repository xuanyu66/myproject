package hacksystem;

/**
 * @author leon on 2018/7/10.
 * @version 1.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class HackSystem
{
    public static PrintStream out ;
    static{
        try
        {
            out = new MyPrintStream(new File("E:/out.txt"));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}