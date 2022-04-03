package com.vic.concurrent.inde;

public class DecreaceThread  implements Runnable{

    private MyObject myObject;

    public DecreaceThread(MyObject myObject){
        this.myObject = myObject;
    }

    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myObject.decreace();
        }

    }
}
