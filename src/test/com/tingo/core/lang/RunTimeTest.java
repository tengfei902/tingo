package tingo.core.lang;

import org.junit.Test;

/**
 * Created by user on 17/8/1.
 */
public class RunTimeTest {

    @Test
    public void testGetRunTimeEnv() {
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
