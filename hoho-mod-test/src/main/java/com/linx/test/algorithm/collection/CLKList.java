package com.linx.test.algorithm.collection;

/**
 * 循环链表：循环单链表、循环双链表。
 *
 */
public class CLKList<T> {
    Node<T> head; //头结点

    public static class Node<T> {
        T data;
        Node<T> prior;
        Node<T> next;
    }

    //初始化
    public CLKList(){
        head = new Node<>();
        head.prior = head; //头结点的prior指向最后一个结点
        head.next = head; //最后一个结点的next指向头结点
    }
}
