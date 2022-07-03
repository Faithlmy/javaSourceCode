package com.spring.bk009;

import com.spring.bk007.Myservice;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;

import java.net.MalformedURLException;

public class MainApp {
    public static void main(String[] args) throws MalformedURLException {
//        ApplicationContext context = new FileSystemXmlApplicationContext("/"+"/Users/lmy/mysoftware/javaSourceCode/src/main/java/com/spring/bk006/Application.xml");
////        ApplicationContext context = new ClassPathXmlApplicationContext("Application.xml");
//        User user = (User) context.getBean("myUser");
//        System.out.println(user.getLmyName());

//        String path = this.getClass().getResource("").getPath();
//        System.out.println(path);

        Resource resource = new FileUrlResource("/Users/lmy/mysoftware/javaSourceCode/src/main/java/com/spring/bk007/Application.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        Myservice myservice = (Myservice)defaultListableBeanFactory.getBean("myAop");
        myservice.myMehtod();
    }
}
