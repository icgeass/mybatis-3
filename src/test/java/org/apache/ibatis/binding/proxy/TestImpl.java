package org.apache.ibatis.binding.proxy;

public class TestImpl implements Test {
    @Override
    public String test(String args) {
        System.out.println(this.getClass().getName() + " do test now...");
        return "test: " + args;
    }
}
