package com.spring.bk006;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.*;

import java.net.MalformedURLException;

public class MainApp {
    public static void main(String[] args) throws MalformedURLException {
//        ApplicationContext context = new FileSystemXmlApplicationContext("/"+"/Users/lmy/mysoftware/javaSourceCode/src/main/java/com/spring/bk006/Application.xml");
////        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
//        User user = (User) context.getBean("myUser");
//        System.out.println(user.getLmyName());

//        String path = this.getClass().getResource("").getPath();
//        System.out.println(path);

        Resource resource = new FileUrlResource("/Users/lmy/mysoftware/javaSourceCode/src/main/java/com/spring/bk006/Application.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        User user = (User)defaultListableBeanFactory.getBean("myUser");
        System.out.println(user.getLmyName());
    }
}
