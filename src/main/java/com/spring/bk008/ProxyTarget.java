package com.spring.bk008;

public class ProxyTarget implements Target{

    private RealTaeget realTaeget;

    @Override
    public void myRequest() {
        this.bf();
        if (realTaeget == null){
            realTaeget = new RealTaeget();
            realTaeget.myRequest();
        }
        this.af();

    }

    private void bf(){
        System.out.println("bf");
    }

    private void af(){
        System.out.println("af");
    }
}
