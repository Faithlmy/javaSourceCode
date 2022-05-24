package com.spring;

public class MyApplicationContext implements ClassPathXmlApplicationContext{
    public MyApplicationContext(String... configLocations) throws BeansException {
        super(configLocations);
    }

    protected void initPropertySources() {
        getEnvironment().setRequiredProperties("ljj");
    }
}
