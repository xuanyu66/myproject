package hacksystem;

/**
 * @author leon on 2018/7/10.
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Character cd = 'y';
        Character dd = 'y';
        System.out.println(cd == dd);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == a + b);
        System.out.println(g.equals(a + b));
/*        可以看出来 Integer 也有常量池 范围是 -128~127
        所以在此范围内的 == 返回true，范围外的 范围false。（当然，equals全部返回true）

        同样，Short Long 的常量池范围也是－128～127。

        Boolean 也实现了常量池的功能。毕竟只有true和false两个值

        Character的范围0~127*/
    }
}
