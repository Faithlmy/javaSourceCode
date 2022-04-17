package com.vic.dataStructure;

public class LarryBinaryTreeApp {
    public static void main(String[] args) {

    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}

class LarryBinaryTree {

    // 根节点
    public TreeNode rootNode;

    // 私有方法构建二叉树
    private TreeNode addNode(TreeNode currentNode, int value) {
        // 根节点为null，直接新建一个节点
        if (currentNode == null) {
            return new TreeNode(value);
        }
        if (value < currentNode.value) {
            // 如果当前插入节点小于根节点的值，在树的左节点插入值
            currentNode.left = addNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = addNode(currentNode.right, value);
        } else {
            return currentNode;
        }
        return currentNode;
    }

    //
    public void addNode(int value) {
        rootNode = addNode(rootNode, value);
    }

    // 递归判断节点是否含有值
    public boolean isContainNode(TreeNode treeNode, int value) {
        //currentNode，直接返回false
        if (treeNode == null) return false;
        //如果根节点存在并且值等于当前查找值，返回true
        if (treeNode.value == value) return true;
        //如果目标值大于当前节点值，则在右子树递归查找，反之在左子树递归查找
        return value > treeNode.value ? isContainNode(treeNode.right, value) : isContainNode(treeNode.left, value);
    }

    private TreeNode deleteNode(TreeNode currentNode, int value) {

        // 从根节点开始找value是否存在
        if (!isContainNode(rootNode, value) || currentNode == null) {
            return null;
        }
        //
        if (currentNode.value == value) {

        }


        return currentNode;
    }


}