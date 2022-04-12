package com.vic.dataStructure;

public class LarryDoubleLinkedApp {
    public static void main(String[] args) {

    }
}

class NodeD<E> {

    public NodeD prev;
    public E element;
    public NodeD next;

    public NodeD(E element) {
        this.element = element;
    }

}

class LarryDoubleLinked<E> {
    private NodeD head;

    public LarryDoubleLinked() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirstValue(E value) {
        NodeD<E> eNodeD = new NodeD<>(value);
        if (!isEmpty()) {
            this.head.prev = eNodeD;
        }
        eNodeD.next = this.head;
        this.head = eNodeD;

    }

    public void addLastValue(E value) {
        NodeD<E> eNodeD = new NodeD<>(value);

    }

    public void display() {
        NodeD cur = this.head;
        while (true) {
            System.out.println(cur.element);
            cur = cur.next;
            if (cur == null) {
                break;
            }
        }
    }

}
