package com.vic.dataStructure;

public class LarryQueueApp {
    public static void main(String[] args) {

    }
}

class LarryQueue<E> {
    private int maxSize; // 最大元素
    private E[] queArray;
    private int front; // 队头
    private int rear;  // 队尾

    public LarryQueue(int size) {
        this.maxSize = size;
        queArray = (E[]) new Object[maxSize];
        front = 0;
        rear = -1;
    }

    public void insert(E value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = value;
    }

    public E remove() {
        E temp = queArray[front++];
        return temp;
    }

    public int getSize() {
        return rear - front + 1;
    }

    public boolean isFull() {
        return (rear == maxSize - 1);
    }

    public boolean isEmpty() {
        return (getSize() == 0);
    }

    public E peak() {
        return queArray[front];
    }

    public void print() {
        while (!isEmpty()) {
            System.out.println(queArray[front++]);
        }
        front = 0;
    }

}
