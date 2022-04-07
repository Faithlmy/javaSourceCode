package com.vic.javabase.reflex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemonstration {
    public static void main(String[] args) {
        //代理的真实对象
        Subject realSubject = new RealSubject();
        System.out.println("########");
        System.out.println(realSubject.getClass().getName());
        System.out.println(realSubject.SayHello("898989"));
        System.out.println("########");

        /**
         * InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
         * 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用.
         * 即：要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法
         */
        InvocationHandler handler = new InvocationHandlerImpl(realSubject);

        ClassLoader loader = realSubject.getClass().getClassLoader();
        Class[] interfaces = realSubject.getClass().getInterfaces();

        Subject subject = (Subject) Proxy.newProxyInstance(loader, interfaces, handler);

        System.out.println("--------");
        System.out.println(subject.hashCode());
        System.out.println(realSubject.hashCode());
        System.out.println( realSubject == subject);
        System.out.println( realSubject.equals(subject));
        System.out.println("--------");
        String name = subject.getClass().getName();

        System.out.println("动态代理对象的类型："+ name);
        System.out.println(subject.SayHello("898989"));
        String hello = subject.SayHello("jiankunking");
        System.out.println(hello);
        String goodbye = subject.SayBuye("bbb");
        System.out.println(goodbye);

//        int i = subject002.funSum(89);
//        System.out.println(i);



    }
}
