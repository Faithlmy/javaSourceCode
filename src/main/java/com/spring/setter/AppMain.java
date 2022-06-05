package com.spring.setter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        Service setvice = (Service)ac.getBean("service");
        setvice.test();
    }
}
