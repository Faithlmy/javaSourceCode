package com.javabase.concurrent.inde;

public class IncreaceThread extends Thread {
    private MyObject myObject;

    public IncreaceThread(MyObject myObject){
        this.myObject = myObject;

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject.increace();
        }
    }
}
