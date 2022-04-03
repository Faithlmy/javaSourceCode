package com.vic.concurrent;

/**
 *
 * 1。 调用wait方法的时候，线程必须持有被调用对象的锁；调用wait方法后，线程会释放该对象的锁
 * 2。 调用Thread的sleep方法的时候，线程不会释放掉对象的锁（即线程调用sleep后会继续拥有这个对象的锁）
 *
 * 1. 当线程调用wait方法的时，首先确保调用wait方法的线程已经持有对象的锁；（这就是为什么规定要将wait写在synchronized块或者方法中）
 * 2. 当线程调用wait方法后，该线程就会释放掉这个对象的锁，然后进入等待状态（也就是wait set集合中）
 * 3. 一旦这个线程被其他线程唤醒后，该线程就会和其他线程一同竞争这个对象的锁（公平锁），只有这个线程这个对象的锁之后，线程才会往下执行
 * 4. 当线程调用notify 或者 notifyAll， 该线程就会去随机唤醒该对象等待集合（wait set）中任意一个（全部线程）线程，该线程就会与其他线程一同去竞争对象的锁
 * 5. 某一时刻，只有唯一一个线程拥有对象的锁。
 *
 *
 */
public class LarryVic01 {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        synchronized (obj){
            obj.wait();
        }

    }
}
