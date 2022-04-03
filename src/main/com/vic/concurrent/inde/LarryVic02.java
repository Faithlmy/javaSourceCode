package com.vic.concurrent.inde;

/**
 * 交替执行  0101010010
 */
public class LarryVic02 {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        Thread increaceThread = new IncreaceThread(myObject);
        Thread increaceThread1 = new IncreaceThread(myObject);
        DecreaceThread decreaceThread = new DecreaceThread(myObject);

        increaceThread.start();
        increaceThread1.start();
//        decreaceThread.start();

        Thread thread = new Thread(decreaceThread);
        Thread thread1 = new Thread(decreaceThread);
        thread.start();
        thread1.start();


    }

}
