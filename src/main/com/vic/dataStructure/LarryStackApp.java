package com.vic.dataStructure;

public class LarryStackApp {
    public static void main(String[] args) {

    }
}
class LarryStackE<E> {
    private int maxSize; // 栈的最大元素
    private int top;// 栈顶元素
    private E[] stackArray;

    public LarryStackE(int index) {
        maxSize = index;
        top = -1;
        stackArray = (E[]) new Object[maxSize];
    }

    // 入栈
    public void push(E value) {
        stackArray[++top] = value;
    }

    // 出栈
    public E pop() {
        return stackArray[top--];
    }

    // 栈的peak
    public E peak() {
        return stackArray[top];
    }

    //是否为空
    public boolean isEmpty() {
        return (top == -1);
    }

    //是否满栈
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

// 字母反转
class Reverser{
    private String inputStr;
    private String outputStr;
    public Reverser(String inputStr){
        this.inputStr = inputStr;
    }
    public String doRev() {
        int stackSize = inputStr.length();
        LarryStackE<String> stringLarryStackE = new LarryStackE<String>(stackSize);
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            stringLarryStackE.push(String.valueOf(c));
        }
        outputStr = "";
        while (!stringLarryStackE.isEmpty()) {
            String pop = stringLarryStackE.pop();
            outputStr = outputStr + pop;


        }
        return outputStr;
    }
}
