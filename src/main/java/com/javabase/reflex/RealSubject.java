package com.javabase.reflex;

public class RealSubject implements Subject {

    @Override
    public String SayHello(String str) {
        return "lmy" + str;
    }

    @Override
    public String SayBuye(String str) {
        return str;
    }
}
