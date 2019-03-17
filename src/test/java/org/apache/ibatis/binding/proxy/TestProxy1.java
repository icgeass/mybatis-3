package org.apache.ibatis.binding.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestProxy1 implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy begin...");
        System.out.println("屏蔽了目标对象，不调用实际方法");
        System.out.println("proxy end...");
        return null;
    }
}
