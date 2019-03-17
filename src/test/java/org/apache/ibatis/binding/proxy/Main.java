package org.apache.ibatis.binding.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Test proxy = (Test) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                new Class[]{Test.class},
                new TestProxy(new TestImpl()));

        System.out.println(proxy.test("hello"));

        System.out.println(proxy.getClass().getName());
        System.out.println("==================================");

        Test proxy1 = (Test) Proxy.newProxyInstance(
                Test.class.getClassLoader(),
                new Class[]{Test.class},
                new TestProxy1());

        proxy1.test("hello1");
    }
}
