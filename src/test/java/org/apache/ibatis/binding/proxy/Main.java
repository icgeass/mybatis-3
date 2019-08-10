/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
