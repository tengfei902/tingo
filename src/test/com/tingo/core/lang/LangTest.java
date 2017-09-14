package tingo.core.lang;

import org.junit.Test;

/**
 * Created by user on 17/7/31.
 */
public class LangTest {
    @Test
    public void testString() {
        String a = "";
//        SelfDefineString s = "";
    }

    @Test
    public void testByte() {
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        int i = a+1;
        System.out.println(i);
        i = i-1;
        System.out.println(i);

        int m = 2147483647;
        m = m+1;
        System.out.println(m);
        m = m+1;
        System.out.println(m);
        m = m+1;
        System.out.println(m);

        while(true) {
            m++;
            System.out.println(m);
            if(m==-2147483648) {
                break;
            }
        }
    }
}
