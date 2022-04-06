package com.vic.concurrent.hello;

public class Mythread2 {
    public static void main(String[] args) {
        Myclass myclass = new Myclass();
        Myclass myclass1 = new Myclass();

        Thread1 thread1 = new Thread1(myclass);
        Thread2 thread2 = new Thread2(myclass1);
        thread1.start();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();

    }
}

class Myclass{
    public synchronized void hello(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }

    public synchronized void world(){
        System.out.println("world");
    }
}

class Thread1 extends Thread{
    private Myclass myclass;

    public Thread1(Myclass myclass){
        this.myclass = myclass;
    }

    @Override
    public void run() {
        myclass.hello();
    }
}

class Thread2 extends Thread{
    private Myclass myclass;

    public Thread2(Myclass myclass){
        this.myclass = myclass;
    }

    @Override
    public void run() {
        myclass.hello();
    }
}