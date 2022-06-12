package com.spring.setter;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MyReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("替代"+objects+"中的方法，方法名称："+method.getName());
        System.out.println("执行新方法中的逻辑");
        return null;
    }
}
