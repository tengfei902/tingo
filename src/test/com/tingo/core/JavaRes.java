package tingo.core;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * Created by user on 17/8/28.
 */
public class JavaRes {

    @Test
    public void testGetDate() {
        Date date = DateUtils.addDays(new Date(),14);
        System.out.println(date.getTime());

        System.out.println(new Date().getTime());
    }

}
