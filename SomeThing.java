import java.lang.reflect.Field;

/**
 * @author leon on 2018/5/31.
 * @version 1.0
 */
public class SomeThing {
    static int RUN = 1;

    public static void main(String[] args) {
        Class aClass=Main.class;
        Field[] methods = aClass.getFields();
        System.out.println(methods.length);
        for (Field d : methods) {
            System.out.println(d.toString());
            System.out.println(d.getName());
            System.out.println(d.getType());
        }
    }
}
