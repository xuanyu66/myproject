/**
 * @author leon on 2018/5/31.
 * @version 1.0
 */
import java.util.Arrays;

public class Main {
    public String abs = "asd";
    String sss = "aaa";
    public static void main(String[] args) {
        String a="ABCDABEABCDAF";
        int [] b =getNext1(a);
        int [] c =getNext2(a);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
    public static int[] getNext1(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {
                // 当两个字符相等时要跳过
                if (p[++j] == p[++k]) {

                    next[j] = next[k];

                } else {

                    next[j] = k;

                }

            } else {

                k = next[k];

            }

        }

        return next;

    }
    public static int[] getNext2(String ps) {

        char[] p = ps.toCharArray();

        int[] next = new int[p.length];

        next[0] = -1;

        int j = 0;

        int k = -1;

        while (j < p.length - 1) {

            if (k == -1 || p[j] == p[k]) {

                next[++j] = ++k;

            } else {

                k = next[k];

            }

        }

        return next;

    }
}
