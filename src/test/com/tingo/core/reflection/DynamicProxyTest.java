package tingo.core.reflection;

import java.lang.reflect.Proxy;

/**
 * Created by user on 17/1/16.
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        DynamicInterface target = new DynamicProxyTarget();
        DynamicInterface proxy = (DynamicInterface)Proxy.newProxyInstance(DynamicInterface.class.getClassLoader(),new Class[]{DynamicInterface.class},new DynamicProxy(target));
        proxy.write();
    }
}
