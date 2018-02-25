package tingo.core;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by user on 16/11/1.
 */
public class CommonTest {

    private static MathContext mc = new MathContext(3,RoundingMode.HALF_UP);

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(210.92);
        BigDecimal b2 = new BigDecimal(2.20);
        BigDecimal b3 =  b1.subtract(b2);
        System.out.println(b3);
        BigDecimal b4 = b1.add(b2);
        System.out.println(b4);
    }


}
