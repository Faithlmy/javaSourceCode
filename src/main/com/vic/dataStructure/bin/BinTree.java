package com.vic.dataStructure.bin;

public class BinTree extends AbstractTree{
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
            int data = parentNode.data;
            Node curLeftMax = getCurLeftMax(curNode.leftNode, curNode);
            parentNode.leftNode = curLeftMax;
        }
        return false;
    }
    public Node getCurLeftMax(Node curLeft, Node cur){
        Node curLeftNode = curLeft;
        while (curLeftNode != null && curLeftNode.rightNode != null){
            curLeftNode = curLeftNode.rightNode;
        }
        // 1. 当前节点没有左子树
        if (curLeftNode.leftNode == null && curLeftNode.rightNode == null){
            Node parent = getParent(curLeft, curLeftNode);
            parent.rightNode = null;

            curLeftNode.leftNode = curLeft;
            curLeftNode.rightNode = cur.rightNode;
            return curLeftNode;
        }

        // 2. 当前节点有左子树
        if (curLeftNode.leftNode != null){
            Node parent = getParent(curLeft, curLeftNode);
            if (parent.data > curLeftNode.leftNode.data){
                parent.leftNode = curLeftNode.leftNode;
                parent.rightNode = null;
            }
            if (parent.data <= curLeftNode.leftNode.data){
                parent.rightNode = curLeftNode.leftNode;
                if (curLeft.data >= curLeftNode.data){
                    curLeftNode.rightNode = curLeft;
                }
                if (curLeft.data < curLeftNode.data){
                    curLeftNode.leftNode = curLeft;
                    curLeftNode.rightNode = cur.rightNode;
                }

            }
        }


        return curLeftNode;
    }
    // 获取当前节点的父节点
    public Node getParent(Node nodeAll, Node cur){
        if(nodeAll == null ||nodeAll.leftNode == cur || nodeAll.rightNode == cur) return nodeAll;
        Node left = getParent(nodeAll.leftNode, cur);
        if(left != null) return left;
        Node right = getParent(nodeAll.rightNode, cur);
        if(right != null) return right;
        return left;
    }
}
