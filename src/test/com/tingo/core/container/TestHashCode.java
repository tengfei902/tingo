package tingo.core.container;

import tingo.core.domain.TestDoamin;

/**
 * Created by tengfei on 2017/1/16.
 */
public class TestHashCode {

    public static void main(String[] args) {
        TestDoamin domain = new TestDoamin(1L,"test");
        System.out.println(domain.hashCode());
        TestDoamin domain1 = new TestDoamin(1L,"test");
        System.out.println(domain1.hashCode());
    }
}
