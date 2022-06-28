package com.spring.bk007;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Bf   ----->  invocation");
        Object proceed = invocation.proceed();
        System.out.println("Af   ----->  invocation");
        return proceed;
    }
}
