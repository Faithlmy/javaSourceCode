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

    private NodeD head; // 头
    private NodeD tail; // 尾
    int size;

    public LarryDoubleLinked() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    // 头
    public void addFirstValue(E value) {
        NodeD<E> eNodeD = new NodeD<>(value);
        if (isEmpty()) {
            this.head = eNodeD;
            this.tail = eNodeD;
        } else {
            eNodeD.next = this.head;
            this.head.prev = eNodeD;
        }
        this.head = eNodeD;
        size++;

    }

    // 尾
    public void addLastValue(E value) {
        NodeD<E> eNodeD = new NodeD<>(value);
        if (isEmpty()) {
            this.tail = eNodeD;
            this.head = eNodeD;
        } else {
            eNodeD.prev = this.tail;
            this.tail.next = eNodeD;
        }
        this.tail = eNodeD;
        size++;

    }

    // 中间
    public void addMiddleValue(int minSize1, int maxSize2, E value) {
        // 处理有两个元素以上的链表
        if (size >= 2 && (maxSize2 - minSize1 == 1) && maxSize2 <= size && minSize1 <= size) {
            int flag = size;
            NodeD<E> eNodeD = new NodeD<>(value);
            NodeD cur = this.head;
            while (true) {
                if (cur == null) {
                    break;
                }
                if (minSize1 == flag) {
                    eNodeD.next = cur;
                    eNodeD.prev = cur.prev;
                    cur.prev.next = eNodeD;
                    cur.prev = eNodeD;
                    break;
                }
                cur = cur.next;
                flag--;
            }
        }
    }

    public NodeD searchNode(int index) {
        NodeD cur = this.head;
        while (index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /**
     * 如果是两删除的元素正好是tail或者head，需要判断null
     *
     * @param index
     */
    public void deleteValue(int index) {
        NodeD nodeD = searchNode(index);
        nodeD.prev.next = nodeD.next;
        nodeD.next.prev = nodeD.prev;
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
