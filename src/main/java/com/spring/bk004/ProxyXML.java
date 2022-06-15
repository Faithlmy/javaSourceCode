package com.spring.bk004;

public class ProxyXML {
    public void seeHouse(){
        System.out.println("带客户看房子");
    }
​
    public Object getMoney(ProceedingJoinPoint p){
        System.out.println("租房.....before");
        Object o = null;
        try{
            o = p.proceed();
        }catch(Throwable e){
            e.printStackTrace();
        }
        System.out.println("租房.....after");
        return o;
    }
​
    public void fare(){
        System.out.println("收取中介费");
    }
}
