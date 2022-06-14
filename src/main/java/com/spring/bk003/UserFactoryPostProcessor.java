package com.spring.bk003;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class UserFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("UserFactoryPostProcessor");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("user");
        MutablePropertyValues pv = beanDefinition.getPropertyValues();
        if (pv.contains("name")){
            pv.addPropertyValue("name","acorn");
        }
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
