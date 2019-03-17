package org.apache.ibatis.binding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy implements InvocationHandler {

    private Test targetObject;

    public TestProxy(Test targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy begin...");
        System.out.println(method);
        System.out.println(args[0]);
        Object obj = method.invoke(this.targetObject, args);
        System.out.println("proxy end...");
        return obj;
    }
}
