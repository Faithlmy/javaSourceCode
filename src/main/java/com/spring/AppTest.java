package com.spring;

public class AppTest {
    public static void main(String[] args) {
        BeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory);

        ClassPathResource resource = new ClassPathResource("user.xml");
        reader.loadBeanDefinitions(resource);

        User user = (User) factory.getBean("user");
        System.out.println(user.getId());
        System.out.println(user.getName());
    }
}
