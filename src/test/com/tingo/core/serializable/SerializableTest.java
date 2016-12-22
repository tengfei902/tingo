package tingo.core.serializable;

import java.io.*;

/**
 * Created by tengfei on 2016/11/27.
 */
public class SerializableTest {

    public static void main(String[] args) {
        write();
        read();
    }

    public static void write() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my.out"));
            MyDomain domain = new MyDomain(1L,"张三",16,10,"信息与计算科学");
            oos.writeObject(domain);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("my.out"));
            MyDomain domain = (MyDomain) ois.readObject();
            System.out.println("id:"+domain.getId());
            System.out.println("name:"+domain.getName());
            System.out.println("age:"+domain.getAge());
            System.out.println("sex:"+domain.getSex());
            System.out.println("major:"+domain.getMajor());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class MyDomain implements Serializable{
    private Long id ;
    private String name ;
    private Integer age;
    private static Integer sex;
    private transient String major;

    public MyDomain(Long id,String name,Integer age,Integer sex,String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        MyDomain.sex = sex;
        this.major = major;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static Integer getSex() {
        return sex;
    }

    public static void setSex(Integer sex) {
        MyDomain.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
