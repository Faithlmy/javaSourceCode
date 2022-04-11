package com.vic.dataStructure;

public class LarryLinkedApp {
    public static void main(String[] args) {

    }
}


class Node<E>{
    public E element; // 节点元素
    public Node next; // next节点
    // 构造函数
    public Node(){}
    public Node(E element, Node next){
        this.element = element;
        this.next = next;
    }
    public Node(E element){
        this(element, null);
    }

}

class LarryLinked<E> {

    // 定义单独一个Node节点的数据结构

    public Node head; // 头结点
    public int size; // 节点个数
    public Node curNode;// 头节点的影子

    public LarryLinked() {
        this.head = null;
        this.size = 0;
        this.curNode = head;
    }

    public boolean isEmpty() {
        return curNode == null;
    }

    public int getSize() {
        return size;
    }

    public void insetValue(E value) {
        Node<E> eNode = new Node<>(value);
        eNode.next = head;
        head = eNode;
        size++;
        curNode = head;
    }

    public Node deleteValue() {
        Node temp = head;
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
        curNode = head;
        return temp;
    }

    public Node getValue() {
        return curNode;
    }

    public void display() {
        while (!isEmpty()) {
            System.out.println(getValue().element);
            curNode = curNode.next;
        }
        curNode = head;
    }


    // 给指定位置插入元素
    public boolean insertIndexValue(E value, int index) {
        if (index < 0 || index > getSize()) {
            return false;
        }
        if (index == size) {
            insetValue(value);
            return true;
        }
        int flag = 0;
        while (true) {
            if (flag == index) {
                Node<E> eNode = new Node<E>(value);
                eNode.next = curNode;
                curNode = eNode;
                eNode.next = curNode.next;
                //                eNode.next = curNode;
//                curNode = eNode;
                break;
            }
            curNode = curNode.next;
            flag++;
        }
        return true;
    }
}
