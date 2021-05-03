package com.linx.test.algorithm.collection;

/**
 * 双链表
 */
public class DLkList<T> {
    public Node<T> head; // 头节点

    private static class Node<T> { //链表节点
        public T data;
        public Node<T> prior;
        public Node<T> next;//后继节点
    }

    //头插法
    public void DLKListF(T[] list) {
        Node<T> head = new Node<>();
        head.prior = head.next = null;//头节点的两个节点都为空。
        for (int i = 0; i < list.length - 1; i++) {
            Node<T> node = new Node<>();//创建新节点
            node.data = list[i];
            node.next = head.next;
            if (head.next != null) {
                head.next.prior = node;
            }
            head.next = node;
            node.prior = head;
        }
    }

    //尾插法
    public DLkList(T[] list) {
        Node<T> head = new Node<>();
        head.prior = head.next = null;
        Node<T> end = head;//尾节点
        for (int i = 0; i < list.length -1; i++) {
            Node<T> node = new Node<>();
            node.data = list[i];
            end.next = node;
            node.prior = end;
            end = node;
        }
        end.next = null;//尾节点next域置为null
    }


    //在i位置上插入值为e的元素。
    public int insert(int i, T element) {
        //找到位置为i的元素
        int j = 0;
        Node<T> p = head;//p指向头节点
        while (j < i -1 && p != null) {
            j++;
            p = p.next;
        }//找到的是i位置的前一个节点。
        if (p == null) {
            return 0;
        } else {
            Node<T> node = new Node();
            node.data = element;
            node.next = p.next;
            node.prior = p;
            if (p.next != null) {
                p.next.prior = node;
            }
            p.next = node;
        }
        return 1;
    }

    //删除i位置上的值。并返回删除的值
    public int delete(int i) {
        int j = 0;
        Node<T> p = head; //p指向头节点
        while (j < i -1 && p != null) {
            j++;
            p = p.next;
        }
        if (p == null) {
            return 0;
        } else {
            Node<T> q = p.next;//需要删除的节点
            if (q == null) {
                return 0;
            }
            p.next =  q.next;
            if (q.next != null) {
                q.next.prior = p;
            }
            q = null; //删除节点
            return 1;
        }
    }

}
