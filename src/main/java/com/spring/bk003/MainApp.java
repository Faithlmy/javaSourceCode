package com.spring.bk003;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("/Users/lmy/mysoftware/javaSourceCode/src/main/java/com/spring/bk003/Application.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }
}
