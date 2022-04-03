package com.vic.concurrent.inde;

public class MyObject {
    private int counter;

    public synchronized void increace(){
//        if (counter != 0){
        while (counter != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println(counter);
        notify();
    }

    public synchronized void decreace(){
//        if (counter == 0){
        while (counter == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println(counter);
        notify();
    }
}
