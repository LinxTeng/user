package com.linx.test.algorithm.collection;

import org.omg.CORBA.Object;

/**
 * 顺序存储结构的队列:队尾进队头出（逆时针前进）
 *
 * 使用到的技巧：
 * 循环首尾相连：
 * 前进一位的操作是：rear = (rear + 1 ) % MaxSize
 * 后退一步的操作是: rear = (rear - 1 + maxSize) % maxSize
 *
 * 注意:
 *     front对应的位置是不存储值的。
 *
 * @param <T>
 */
public class SqQueue<T> {
    public int maxSize;
    public T[] data;
    public int front; //队首指针
    public int rear; //队尾指针

    /**
     * 初始化队列
     * @param i
     */
    public SqQueue(int i) {
        maxSize = i;
        data = (T[]) new Object[i];
        front = 0;
        front = 0;
    }

    /**
     * 销毁队列
     */
    void clear(){
        data = null;
    }

    /**
     * 判断队列是否为空
     */
    boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 入队列
     */
    public int enQueue(T e) {
        if (isFull()) {
            return 0;
        }
        rear = (rear + 1) % maxSize;
        data[rear] = e;
        return 1;
    }

    /**
     * 出队列
     */
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % maxSize;
        return data[front];
    }

    /**
     * 从队尾删除
     */
    T delete() {
        if (isEmpty()) {
            return null;
        }
        T e = data[rear];
        rear = (rear - 1 + maxSize) % maxSize;//后退一步, 防止rear刚好处于0的位置时，减一不加最大值就会变为负数。
        return e;
    }

    /**
     * 从对头插入
     */
    public int insert(T e) {
        if (isFull()) {
            return 0;
        }
        data[front] = e; //注意，front对应的位置是不存储值的。
        front = (front - 1 + maxSize) % maxSize;
        return 1;
    }
}
