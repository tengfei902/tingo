package tingo.core.dp;

import org.junit.Test;

import java.util.List;

/**
 * Created by user on 17/8/12.
 */
public class ProtoTypeTest {

    @Test
    public void testProtoType() throws CloneNotSupportedException {
        ProtoType origin = new ProtoType();
        ProtoType target = (ProtoType) origin.clone();
    }
}

class ProtoType implements Cloneable {
    private String name;
    private int age;
    private int sex;
    private List<String> habbits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public List<String> getHabbits() {
        return habbits;
    }

    public void setHabbits(List<String> habbits) {
        this.habbits = habbits;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
