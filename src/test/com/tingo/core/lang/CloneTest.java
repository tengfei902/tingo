package tingo.core.lang;

import com.google.gson.Gson;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 17/8/1.
 */
public class CloneTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        Target target1 = new Target();
        target1.setA(10);
        target1.setB("abc");
        Map<String,String> map = new HashMap<String, String>();
        map.put("acb","234567");
        target1.setC(map);
        Target target2 = (Target) target1.clone();

        target1.setB("abcde");
        target1.getC().put("123456","12345657");
        System.out.println(new Gson().toJson(target2));

        System.out.println(target1.getC().toString());
        System.out.println(target2.getC().toString());
    }
}

class Target implements Cloneable {
    private int a;
    private String b;
    private Map<String,String> c;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Map<String, String> getC() {
        return c;
    }

    public void setC(Map<String, String> c) {
        this.c = c;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
