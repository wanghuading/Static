package com.sz.learn.link;

/**
 * @Author whd
 * @Date 2018/5/14 15:00
 * @Description
 **/
public class SingleLink<T extends Comparable> {
    private class Node<T extends Comparable> {
        private T data;
        private Node next;
        private Node(T data) {
            this(data, null);
        }
        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;

    public boolean add(T data) {
        Node node  = new Node(data);
        if (head == null) {
            head = node;
        } else {
            int result = node.data.compareTo(head.data);
            if (result < 0) {
                node.next = head;
                head = node;
                return true;
            } else if (result == 0) {
                System.err.println("元素已存在");
                return false;
            }

            Node current = head.next;
            Node preNode = head;


            while (current != null) {
                result = node.data.compareTo(current.data);
                if (result < 0) {
                    node.next = current;
                    preNode.next = node;
                    return true;
                } else if (result == 0) {
                    System.err.println("元素已存在");
                    return true;
                }
                current = current.next;
                preNode = preNode.next;
            }

            if (preNode != null) {
                preNode.next = node;
            }
        }
        return true;
    }

    public SingleLink merge(SingleLink link) {
        SingleLink mergeLink = new SingleLink();


        Node<T> linkNode1 = this.head;
        Node<T> linkNode2 = link.head;
        int result = linkNode1.data.compareTo(linkNode2.data);
        if (result <= 0) {
            mergeLink.head = linkNode1;
            linkNode1 = linkNode1.next;
        } else {
            mergeLink.head = linkNode2;
            linkNode2 = linkNode2.next;
        }
        Node<T> mergeNode = mergeLink.head;

        while (linkNode1 != null && linkNode2 != null) {
            result = linkNode1.data.compareTo(linkNode2.data);
            if (result < 0) {
                mergeNode.next = linkNode1;
                linkNode1 = linkNode1.next;
            } else if (result > 0){
                mergeNode.next = linkNode2;
                linkNode2 = linkNode2.next;
            } else {
                mergeNode.next = linkNode1;
                linkNode1 = linkNode1.next;
                linkNode2 = linkNode2.next;
            }
            mergeNode = mergeNode.next;
        }

        while (linkNode1 != null) {
            mergeNode.next = linkNode1;
            linkNode1 = linkNode1.next;
            mergeNode = mergeNode.next;
        }
        while (linkNode2 != null) {
            mergeNode.next = linkNode2;
            linkNode2 = linkNode2.next;
            mergeNode = mergeNode.next;
        }
        return mergeLink;
    }

    public void ergodic(Node<T> p) {
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public boolean isRing() {
        Node<T> slow = this.head;
        Node<T> fast = this.head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.data.compareTo(slow.data) ==  0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SingleLink link = new SingleLink();
        link.add(9);
        link.add(8);
        link.add(0);
        link.add(11);

        SingleLink link2 = new SingleLink();
        link2.add(15);
        link2.add(36);
        link2.add(8);
        link2.add(3);
        link2.add(39);

        SingleLink mergeLink = link.merge(link2);

        mergeLink.ergodic(mergeLink.head);

    }
}
