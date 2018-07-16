package com.sz.learn.stack;

import java.util.Arrays;

/**
 * @Author whd
 * @Date 2018/5/12 21:59
 * @Description
 **/
public class ArrayStack<E> implements IStack<E> {
    private Object[] data = null;
    private int top = -1;
    private int maxSize = 0;
    public ArrayStack() {
        this(10);
    }
    public ArrayStack(int initialSize) {
        if (initialSize >= 0) {
            // 初始化数组
            this.data = new Object[initialSize];
            // 设置栈最大容量
            this.maxSize = initialSize;
            this.top = -1;
        }
    }
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isMax() {
        return top >= maxSize - 1;
    }

    @Override
    public boolean push(E e) {
        if (isMax()) {
            System.err.println("栈已满");
            return false;
        }
        data[++top] = e;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            System.err.println("空栈");
            return null;
        }
        E e = (E) data[top];
        top--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            System.err.println("空栈");
            return null;
        }
        return (E) data[top];
    }

    @Override
    public int getIndex(E e) {
        while (top != -1) {
            Object t = peek();
            System.out.println(t);
            if (t.equals(e)) {
                return top--;
            }
            top--;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public int getStackSize() {
        return this.maxSize;
    }

    @Override
    public void display() {
        while (top != -1) {
            System.out.println(top--);
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();

        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.getStackSize());
        System.out.println(arrayStack.size());
        System.out.println("+"+arrayStack.getIndex(5));
        arrayStack.display();
    }
}
