package com.sz.learn.queue;

import java.util.Arrays;

/**
 * @Author whd
 * @Date 2018/5/12 18:05
 * @Description 队列，基于数组
 **/
public class ArrayQueue<E> {
    Object[] queue;
    int size;

    public ArrayQueue() {
        queue = new Object[10];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E poll() {
        if (isEmpty()) return null;
        E data = (E) queue[0];
        System.arraycopy(queue, 1, queue, 0, size -1);
        size--;
        return data;
    }

    private void ensureCapacity(int size) {
        if (size > queue.length) {
            int len = queue.length + 10;
            queue = Arrays.copyOf(queue, len);
        }
    }

    public void offer(E data) {
        ensureCapacity(size + 1);
        queue[size++] = data;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.offer(i);

        }
        for (int i = 0; i < 20; i++) {
            System.out.println(queue.poll());
        }
    }
}
