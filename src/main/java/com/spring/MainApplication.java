package com.spring;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainApplication {
    public static void main(String[] args) {
//        BeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);
//
//        ClassPathResource resource = new ClassPathResource("user.xml");
//        reader.loadBeanDefinitions(resource);
//
//        User user = (User) factory.getBean("user");
//        System.out.println(user.getId());
//        System.out.println(user.getName());

        Resource classPathResource = new ClassPathResource("config/Application.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);

        User user = (User) defaultListableBeanFactory.getBean("User");
        System.out.println(user.getId());
        System.out.println(user.getName());

    }
}
