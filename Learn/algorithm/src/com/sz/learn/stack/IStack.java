package com.sz.learn.stack;

/**
 * @Author whd
 * @Date 2018/5/12 21:54
 * @Description
 **/
public interface IStack<E> {
    // 判断空栈
    public boolean isEmpty();

    // 判断栈满
    public boolean isMax();

    // 入栈
    public boolean push(E e);

    // 出栈
    public E pop();

    // 返回栈顶
    public E peek();

    // 返回元素在栈中的位置
    public int getIndex(E e);

    // 返回栈的实际长度
    public int size();

    // 返回栈容量
    public int getStackSize();

    // 打印栈
    public void display();
}
