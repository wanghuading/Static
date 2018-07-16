package com.sz.learn.queue;

/**
 * @Author whd
 * @Date 2018/5/12 18:19
 * @Description
 **/
public class LinkQueue<E> {
    class Node<E> {
        Node<E> next = null;
        E data;
        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void offer(E e) {
        Node<E> node = new Node<>(e);
        if (isEmpty()) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public E poll() {
        if (isEmpty()) return null;
        E data = head.data;
        head = head.next;
        return data;
    }

    public int size() {
        Node<E> temp = head;
        int len = 0;
        while (temp != null) {
            len ++;
            temp = temp.next;
        }
        return len;
    }

    public static void main(String[] args) {
        LinkQueue<String> queue = new LinkQueue<>();
        queue.offer("a");
        queue.offer("b");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
