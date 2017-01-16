package tingo.core.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by user on 17/1/16.
 */
public class DynamicProxy implements InvocationHandler {

    private Object proxy;

    public DynamicProxy(Object proxy) {
        this.proxy = proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before.........");
        Object result = method.invoke(proxy,args);
        System.out.println("after..........");
        return result;
    }
}
