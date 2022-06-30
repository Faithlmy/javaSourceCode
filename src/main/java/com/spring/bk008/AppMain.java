package com.spring.bk008;

public class AppMain {
    public static void main(String[] args) {
        Target target = new ProxyTarget();
        target.myRequest();
    }
}
