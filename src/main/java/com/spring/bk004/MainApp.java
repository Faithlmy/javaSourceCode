package com.spring.bk004;

import com.spring.bk003.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("/Users/lmy/mysoftware/javaSourceCode/src/main/java/com/spring/bk004/Application.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.getName());
    }
}
