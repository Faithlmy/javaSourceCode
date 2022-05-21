package com.javabase.concurrent.cur2;

public class LarryVic03 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread);

        thread.start();
        thread1.start();


    }
}

class MyThread implements Runnable{

    int x;
    public void run() {
        x = 0;
        while (true){
            System.out.println("res=: " + x++);
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x == 20){
                break;
            }
        }
    }
}
