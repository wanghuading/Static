package com.sz.learn.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author whd
 * @Date 2018/5/13 9:56
 * @Description
 **/
public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value) {
            this.value = value;
        }

        public void display() {
            System.out.println(this.value + "\t");
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node root = null;
    BinaryTree(int value) {
        root = new Node(value);
        root.leftChild = null;
        root.rightChild = null;
    }

    public Node findKey(int value) {
        Node current = root;
        while (true) {
            if (value == current.value) {
                return current;
            } else if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
    }

    public boolean insert(int value) {
        String error = null;
        Node node = new Node(value);

        if (root == null){
            root = node;
            root.leftChild = null;
            root.rightChild = null;
        } else {
            Node currentNode = root;
            while (true) {
                if (value < currentNode.value) {
                    currentNode = currentNode.leftChild;
                } else if (value > currentNode.value){
                    currentNode = currentNode.rightChild;
                } else {
                    System.err.println("having same value in binary tree");
                    return false;
                }

                if (currentNode == null) {
                    currentNode = node;
                    break;
                }
            }
        }

        return true;
    }

    private void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.leftChild);
        node.display();
        inOrderTraverse(node.rightChild);
    }

    // 中序遍历递归
    public void inOrderTraverse() {
        System.out.println("中序遍历:");
        inOrderTraverse(root);
        System.out.println();
    }

    // 中序遍历非递归
    public void inOrderByStack() {
        System.out.println("中序非递归遍历");
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.rightChild;
            }
        }
    }

    private void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        node.display();
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    public void preOrderTraverse() {
        System.out.println("前序递归遍历");
        preOrderTraverse(root);
    }

    public void preOrderByStack() {
        System.out.println("前序非递归遍历");
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                /*current.display();
                if (current.leftChild != null) {
                    current.leftChild.display();
                }
                if (current.rightChild != null) {
                    current.rightChild.display();
                    stack.push(current.rightChild);
                }
                current = current.leftChild;*/
                stack.push(current);
                current.display();
                current = current.leftChild;
            }
            if (!stack.isEmpty()) {
                current = stack.pop().rightChild;
            }
        }
    }

    private void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        node.display();
    }

    public void postOrderTraverse() {
        System.out.println("后序递归遍历");
        postOrderTraverse(root);
    }

    public void postOrderByStack() {
        System.out.println("后序非递归遍历");
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.leftChild;
            }

            if (!stack.isEmpty()) {
                current = stack.peek().rightChild;
                if (current == null || current == preNode) {
                    current = stack.peek();
                    current.display();
                    preNode = current;
                    current = null;
                }
                /*current = stack.pop();

                if (current.leftChild != null) {
                    current.leftChild.display();
                }

                if (current.rightChild != null) {
                    current.rightChild.display();
                }

                current = current.rightChild;*/
            }
        }
    }

    public void LayerOrder() {
        System.out.println("层序遍历");
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.value);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    public int getMinValue() {
        Node current = root;
        while (true) {
            if (current.leftChild == null) {
                return current.value;
            }
            current = current.leftChild;
        }
    }

    private Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = null;
        Node current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        // 如果后继节点不是删除节点的右子节点时
        if (successor != delNode.rightChild) {
            // 要将后继节点的右子节点指向后继节点父节点的左子节点
            successorParent.leftChild = successor.rightChild;
            // 并将删除节点的右子节点指向后继节点的右子节点
            successor.rightChild = delNode.rightChild;
        }

        // 任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.leftChild = delNode.leftChild;
        return successor;
    }

    public boolean delete(int value) {
        // 需要删除的节点
        Node current = root;
        // 需要删除的节点的父节点
        Node parent = null;
        // 需要删除的节点是否父节点的左子树
        boolean isLeftChild = true;

        while (true) {
            if (value == current.value) {
                break;
            } else if (value < current.value) {
                isLeftChild = true;
                parent = current;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                parent = current;
                current = current.rightChild;
            }

            // 找不到需要删除的节点，直接返回
            if (current == null) {
                return false;
            }

            // 需要删除的节点为叶子节点
            if (current.leftChild == null && current.rightChild == null) {
                // 如果该叶子节点为根节点，将根节点置为null
                if (current == null) {
                    root = null;
                } else {
                    // 如果该叶子节点是父节点的右子节点，将父节点的左子节点置为null
                    if (isLeftChild) {
                        parent.leftChild = null;
                    } else {
                        parent.rightChild = null;
                    }
                }
            }
            // 需要删除的节点有一个子节点，且该子节点为左子节点
            else if (current.rightChild == null) {
                if (current == root) {
                    root = current.leftChild;
                } else {
                    // 如果该节点是父节点的左子节点，将该子节点设置为父节点的左子节点
                    if (isLeftChild) {
                        parent.leftChild = current.leftChild;
                    } else {
                        parent.rightChild = current.leftChild;
                    }
                }
            }
            // 需要删除的节点有一个子节点，且该该子节点为右子节点
            else if (current.leftChild == null) {
                if (current == root) {
                    root = current.rightChild;
                } else {
                    if (isLeftChild) {
                        parent.leftChild = current.rightChild;
                    } else {
                        parent.rightChild = current.rightChild;
                    }
                }
            }
            // 被删除节点有两个子节点
            else {
                Node sucessor = getSuccessor(current);
                // 如果该节点为根节点，将后继节点变为根节点，并将根节点的左子节点变为后继节点的左子节点
                if (current == root) {
                    root = sucessor;
                } else {
                    if (isLeftChild) {
                        parent.leftChild = sucessor;
                    } else {
                        parent.rightChild = sucessor;
                    }
                }
            }
        }
        current = null;
        return true;
    }
}
