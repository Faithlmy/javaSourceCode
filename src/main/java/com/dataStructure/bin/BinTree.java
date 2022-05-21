package com.dataStructure.bin;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTree extends AbstractTree {
    private Node root; // 根节点
    private List<Integer> valueResPre = new ArrayList<>();
    private List<Integer> valueResIn = new ArrayList<>();
    private List<Integer> valueResAfter = new ArrayList<>();

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
        if (null == root) {
            root = nodeNew;
            return true;
        }
        Node curNode = root;
        Node parentNode = null;

        while (curNode != null) {
            parentNode = curNode;
            if (curNode.data > value) {   //当前值比新插入值大
                curNode = curNode.leftNode;
                if (curNode == null) {  //若左节点为空 则直接插入即可
                    parentNode.leftNode = nodeNew;
                    return true;
                }
            } else {  //当前值小于新插入值
                curNode = curNode.rightNode;
                if (curNode == null) {
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

        while (curNode.data != value) {
            parentNode = curNode;
            if (curNode.data > value) {
                isLeft = true;
                curNode = curNode.leftNode;
            } else {
                isLeft = false;
                curNode = curNode.rightNode;
            }
            if (curNode == null) {
                return false;
            }
        }
        // 1 第一种情况 此节点为叶子节点
        if (curNode.leftNode == null && curNode.rightNode == null) {
            if (curNode == root) {
                root = null;
            } else if (isLeft) {
                parentNode.leftNode = null;
            } else {
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
        if (curNode.leftNode != null && curNode.rightNode != null) {
            int data = parentNode.data;
            Node curLeftMax = getCurLeftMax(curNode); // 左节点
            if (isLeft) {
                parentNode.leftNode = curLeftMax;
            }
            if (!isLeft) {
                parentNode.rightNode = curLeftMax;
            }
        }
        return false;
    }


    public Node getCurLeftMax(Node cur) {  // 整理左节点
        Node curLeftNode = cur.leftNode;
        int flag = 0;
        while (curLeftNode != null && curLeftNode.rightNode != null) {
            curLeftNode = curLeftNode.rightNode;
            flag++;
        }
        /**
         * 只有两种情况:
         * 1 当前节点没有左子树
         * 2. 当前节点有左子树
         */
        // 1. 当前节点没有左子树
        if (curLeftNode.leftNode == null) {
            Node parent = getParent(cur, curLeftNode);
            if (flag == 0) {
                curLeftNode.rightNode = parent.rightNode;
                return curLeftNode;
            }

            parent.rightNode = null;
            curLeftNode.leftNode = cur.leftNode;
            if (cur.rightNode != null) {
                curLeftNode.rightNode = cur.rightNode;
            }
            return curLeftNode;
        }
        // 1. 当前节点有左子树
        if (curLeftNode.leftNode != null) {
            Node parent = getParent(cur.leftNode, curLeftNode);
            if (flag == 0) {
                curLeftNode.rightNode = parent.rightNode;
                return curLeftNode;
            }
            parent.rightNode = curLeftNode.leftNode;
            curLeftNode.leftNode = cur.leftNode;
            if (cur.rightNode != null) {
                curLeftNode.rightNode = cur.rightNode;
            }
            return curLeftNode;
        }
        return curLeftNode;
    }

    // 获取当前节点的父节点
    public Node getParent(Node nodeAll, Node cur) {
        if (nodeAll == null || nodeAll.leftNode == cur || nodeAll.rightNode == cur) return nodeAll;
        Node left = getParent(nodeAll.leftNode, cur);
        if (left != null) return left;
        Node right = getParent(nodeAll.rightNode, cur);
        if (right != null) return right;
        return left;
    }


    @Override
    public List<Integer> preOrderStack(Node tree) {
        List<Integer> valueRes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node treeNode = tree;
        while (treeNode != null || !stack.isEmpty()) {
            // 访问节点的左孩子，并且将左孩子入栈
            while (treeNode != null) {
                valueRes.add(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            // 直到节点没有左孩子，则弹出栈顶节点，访问栈顶节点的右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightNode;
            }
        }
        return valueRes;
    }


    @Override
    public List<Integer> preOrderRecursion(Node tree) {
        if (tree == null) {
            return valueResPre;
        }
        valueResPre.add(tree.data);
        preOrderRecursion(tree.leftNode);
        preOrderRecursion(tree.rightNode);
        return valueResPre;
    }

    @Override
    public List<Integer> inOrderStack(Node tree) {
        List<Integer> valueRes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node treeNode = tree;

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                valueRes.add(treeNode.data);
                treeNode = treeNode.rightNode;
            }
        }
        return valueRes;
    }

    @Override
    public List<Integer> inOrderRecursion(Node tree) {
        if (tree == null) {
            return valueResIn;
        }

        inOrderRecursion(tree.leftNode);
        valueResIn.add(tree.data);
        inOrderRecursion(tree.rightNode);
        return valueResIn;
    }


    @Override
    public List<Integer> afterOrderStack(Node tree) {
        List<Integer> valueRes = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node treeNode = tree;
        Node lastVisit = null;   //标记每次遍历最后一次访问的节点

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftNode;
            }
            if (!stack.isEmpty()) {
                // 出栈
                treeNode = stack.pop();
                /**
                 * 这块就是判断treeNode是否有右孩子，
                 * 如果没有输出treeNode.data，让lastVisit指向treeNode，并让treeNode为空
                 * 如果有右孩子，将当前节点继续入栈，treeNode指向它的右孩子,继续重复循环
                 */
                if (treeNode.rightNode == null || treeNode.rightNode == lastVisit) {
                    valueRes.add(treeNode.data);
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    stack.push(treeNode);
                    treeNode = treeNode.rightNode;
                }

            }
        }
        return valueRes;
    }

    @Override
    public List<Integer> afterOrderRecursion(Node tree) {
        if (tree == null) {
            return valueResAfter;
        }

        afterOrderRecursion(tree.leftNode);
        afterOrderRecursion(tree.rightNode);
        valueResAfter.add(tree.data);
        return valueResAfter;
    }

}
