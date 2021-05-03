package com.linx.test.algorithm.collection;

/**
 * 栈的链式存储结构。
 * 规定栈的所有操作都是在单链表的表头进行的
 */
public class LkStack<T> {
    public Node<T> top; //栈顶元素

    public static class Node<T> {
        public T data;
        public Node<T> next;
    }

    public LkStack() {
        top = new Node<>();
        top.next = null;
    }

    /**
     * 进栈。实际是头插法
     * @param e
     */
    public void push(T e) {
        Node<T> s = top;
        Node<T> p = new Node<>();//新建结点
        p.data = e;
        p.next = s.next;
        s.next = p;
    }

    /**
     * 出栈。
     * @return
     */
    public T pop(){
        Node<T> s = top;
        if (s.next == null) {
            return null;
        }
        Node<T> p = s.next;//p指向第一个结点
        T data = p.data;
        s.next = p.next;
        p = null;//释放p
        return data;
    }

    /**
     * 取栈顶元素
     * @return
     */
    public T getTop(){
        Node<T> s = top;
        if (s.next == null) {
            return null;
        }
        return s.next.data;
    }

    /**
     * 显示栈中元素
     */
    public void display(){
        Node<T> s = top.next;
        if (s != null) {
            System.out.println(s.next);
            s = s.next;
        }
    }

    /**
     * 清空栈。包括头结点都要清掉
     */
    public void clearStack() {
        Node<T> p = top; Node<T> q = top.next;
        while (q != null) {
            p = null; // 头结点释放掉，并把q当中头结点
            p = q;
            q = q.next;
        }
        p = null;//此时p指向尾结点释放其空间。
    }

    /**
     * 长度
     * @return
     */
    public int length() {
        int i = 0;
        Node<T> p = top.next;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return top.next == null;
    }


}
