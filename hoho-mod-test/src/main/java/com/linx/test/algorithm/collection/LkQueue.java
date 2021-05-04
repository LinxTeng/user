package com.linx.test.algorithm.collection;

/**
 * 链式存储结构的队列
 * 注意：
 *  队首和对尾是两个指针，而非两个结点。
 */
public class LkQueue<T> {
    Node<T> front;
    Node<T> rear;

    public static class Node<T> {
        T data;
        Node<T> next;
    }

    /**
     * 初始队列
     */
    public LkQueue() {//这里和栈的初始化不一致，意味着front和rear只是一个指针。
        front = null;
        rear = null;
    }

    /**
     * 判断是否为空。rear在有值的情况下指向最后一个结点。
     */
    boolean isEmpty() {
        return rear.next == null;
    }

    /**
     * 销毁队列: 一个一个出队直至为空
     */
    void clear() {
        Node<T> p = front; //p始终指向头结点。
        if (p != null) {
            Node<T> r = p.next;
            while (r != null) {
                p = null; //释放掉p结点。
                p = r;
                r = p.next;
            }
        }
    }

    /**
     * 入队列
     */
    void enQueue(T e) {
        //新建一个存储e的结点
        Node<T> s = new Node<>();
        s.data = e;
        s.next = null;
        if (isEmpty()) {//如果队列为空
            front = rear = s;// 则新结点是队首结点也是队尾结点
        } else {
            rear.next = s;
            rear = s;//队尾指向新结点。
        }
    }

    /**
     * 出队
     */
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T e = front.data;
        if (front == rear) { //如果队列中只有一个结点时，队头和队尾都要置为null
            front = rear = null;
        } else {
            front = front.next;
        }
        return e;
    }

}
