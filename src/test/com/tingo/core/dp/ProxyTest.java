package tingo.core.dp;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by user on 17/8/12.
 */
public class ProxyTest {

    @Test
    public void testProxy() {
        Target target = new Target();
        InvocationHandler invocationHandler = new LocalProxy(target);
        ITarget proxy = (ITarget)Proxy.newProxyInstance(target.getClass().getClassLoader(),new Class[]{ITarget.class},invocationHandler);
        proxy.doSth();
    }
}

interface ITarget {
    void doSth();
}

class Target implements ITarget {
    public void doSth() {
        System.out.println("this is target");
    }
}

class LocalProxy implements InvocationHandler {

    private Object obj;

    public LocalProxy(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start proxy");
        Object result = method.invoke(obj,args);
        System.out.println("finish proxy");
        return result;
    }
}
