package com.vic.dataStructure.bin;

public class BinTree {
    private Node root; // 根节点

    @Override
    public Node find(int value) {
        Node current = root;
        while (current != null) {
            if (current.data > value) {
                current = current.leftNode;
            } else if (current.data < value) {
                current = current.rightNode;
            } else {
                return current;
            }
        }
        return null;
    }
    @Override
    public boolean insert(int value) {
        count++;
        Node nodeNew = new Node(value);
        if (null == root){
            root = nodeNew;
            return true;
        }
        Node curNode = root;
        Node parentNode = null;

        while (curNode != null) {
            parentNode = curNode;
            if (curNode.data > value){   //当前值比新插入值大
                curNode = curNode.leftNode;
                if (curNode == null){  //若左节点为空 则直接插入即可
                    parentNode.leftNode = nodeNew;
                    return true;
                }
            }else {  //当前值小于新插入值
                curNode = curNode.rightNode;
                if (curNode == null){
                    parentNode.rightNode = nodeNew;
                    return true;
                }
            }
        }

        return false;
    }
    @Override
    public boolean delete(int value) {

        count--;
        Node curNode = root;
        Node parentNode = root;
        boolean isLeft = false;  //当前节点是否为左节点

        while (curNode.data != value){
            parentNode = curNode;
            if (curNode.data > value){
                isLeft = true;
                curNode = curNode.leftNode;
            }else {
                isLeft = false;
                curNode = curNode.rightNode;
            }
            if (curNode == null){
                return false;
            }
        }
        // 1 第一种情况 此节点为叶子节点
        if (curNode.leftNode == null && curNode.rightNode == null){
            if (curNode == root){
                root = null;
            }else if (isLeft){
                parentNode.leftNode = null;
            }else {
                parentNode.rightNode = null;
            }
            return true;
        }
        // 2. 有一个孩子的情况
        if (curNode.leftNode == null && curNode.rightNode != null) {
            if (root == curNode) {
                root = curNode.rightNode;
            } else if (isLeft) {
                parentNode.leftNode = curNode.rightNode;
            } else {
                parentNode.rightNode = curNode.rightNode;
            }
        } else if (curNode.leftNode != null && curNode.rightNode == null) {
            if (root == curNode) {
                root = curNode.leftNode;
            } else if (isLeft) {
                parentNode.leftNode = curNode.leftNode;
            } else {
                parentNode.rightNode = curNode.leftNode;
            }
        }
        //3 当前节点有两个节点
        if(curNode.leftNode != null && curNode.rightNode != null){
            //获取删除节点的后继结点
            Node successor = getSuccessor(curNode);
            if (root == curNode) {
                root = successor;
            } else if (isLeft) {
                parentNode.leftNode = successor;
            } else {
                parentNode.rightNode = successor;
            }
        }
        return false;
    }
    public Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightNode;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }
        if (successor != delNode.rightNode) {
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = delNode.rightNode;
            successor.leftNode = delNode.leftNode;
        }
        return successor;
    }

}
