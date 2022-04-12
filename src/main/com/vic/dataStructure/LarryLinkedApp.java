package com.vic.dataStructure;

public class LarryLinkedApp {
    public static void main(String[] args) {

    }
}


class Node<E> {
    public E element; // 节点元素
    public Node next; // next节点

    // 构造函数
    public Node() {
    }

    public Node(E element, Node next) {
        this.element = element;
        this.next = next;
    }

    public Node(E element) {
        this(element, null);
    }

}

class LarryLinked<E> {

    // 定义单独一个Node节点的数据结构

    public Node head; // 头结点
    public int size; // 节点个数

    public LarryLinked() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E value) {
        Node<E> eNode = new Node<>(value);
        if (this.head == null) {
            this.head = eNode;
            return;
        }
        eNode.next = this.head;
        this.head = eNode;
        size++;
    }

    public void addLast(E value) {
        Node<E> eNode = new Node<>(value);
        if (this.head == null) {
            this.head = eNode;
            return;
        }
        Node<E> curNode = this.head;
        // 用curNode将指针移动到链表的尾部
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = eNode;

    }

    public void addAnywhere(int index, E value) {

        Node<E> eNode = new Node<E>(value);
        if (this.head == null) {
            this.head = eNode;
            return;
        }
        // 找前驱位置
        Node prevNode = searchSite(index);
        eNode.next = prevNode.next;
        prevNode.next = eNode;
    }

    public Node searchSite(int index) {
        if (index < 0 || index > this.size) {
            return this.head;
        }
        Node<E> prev = this.head;
        while (index > 1) {
            prev = prev.next;
            index--;
        }
        return prev;
    }

    public Node deleteValue() {
        Node temp = head;
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
        return temp;
    }

    public Node getValue() {
        return head;
    }

    public void display() {
        Node<String> curNode = this.head;
        while (curNode != null) {
            System.out.println(curNode.element);
            curNode = curNode.next;
        }
        curNode = this.head;
    }

    // 给指定位置插入元素
    public boolean insertIndexValue(E value, int index) {
        if (index < 0 || index > getSize()) {
            return false;
        }
        if (index == size) {
            addFirst(value);
            return true;
        }
        int flag = 0;
        while (true) {
            if (flag == index) {
                Node<E> eNode = new Node<E>(value);

                break;
            }

            head = head.next;
            flag++;
        }
        return true;
    }


}

