package com.sz.learn.stack;

/**
 * @Author whd
 * @Date 2018/5/12 23:01
 * @Description
 **/
public class LinkStack<E> {
    private class Node {
        // 数据域
        private Object data = null;
        // 指针域
        private Node next = null;
        public Node() {}
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = null;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean push(Object e) {
        top = new Node(e, top);
        size++;
        return true;
    }

    public E pop() {
        if (isEmpty()) {
            System.err.println("空栈");
        }
        E e = (E) top.data;
        top = top.next;
        size--;
        return e;
    }

    public E peek() {
        return (E) top.data;
    }

    public int getIndex(E e) {
        int i = 0;
        while (top != null) {
            if (top.data == e) {
                return i;
            }
            top = top.next;
            i++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void display() {
        while (top != null) {
            System.out.println(top.data);
            top = top.next;
        }
    }

    public static void main(String[] args) {
        LinkStack<String> linkStack = new LinkStack<>();
        linkStack.push("c");
        linkStack.push("e");
        linkStack.push("b");
        linkStack.push("d");

        System.out.println(linkStack.getIndex("b"));
    }
}
