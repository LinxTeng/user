package com.linx.test.algorithm.collection;

public class LkList<T> {
    Node<T> head; // 头节点

    private static class Node<T> { //链表节点
        private T data;
        private Node<T> next;//后继节点
        private Node<T> prior;//前驱节点。双链表时使用
    }

    public LkList() {//建立一个空链表
        head = new Node<>();
        head.next = null;
    }

    public void LkListF(T[] list) {
        //头插入法建表
        head = new Node<>();//创建头节点
        head.next = null;
        for (int i = 0; i < list.length; i++) {
            Node<T> node = new Node();//新建节点
            node.data = list[i];
            node.next = head.next;
            head.next = node;
        }
    }

    public LkList(T[] list) {
        //尾插入法建表
        head = new Node<>();//创建头节点
        Node<T> end = head;//end始终指向尾节点，开始时指向头节点
        for (int i = 0; i < list.length; i++) {
            Node<T> node = new Node<>();//新建节点
            node.data = list[i];
            end.next = node;
            end = node;//插入一个后，新的节点就变为尾节点了。
        }
        end.next = null;
    }

    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 求长度
     * @return
     */
    public int length() {
        Node<T> node = head.next;
        int n = 0;
        while (node.next != null) {
            n++;
            node = node.next;
        }
        return n;
    }

    /**
     * 输出
     */
    public void display() {
        Node<T> node = head.next;
        while (node != null) {
            System.out.printf("%s ", node.data);
            node = node.next;
        }
    }

    /**
     * 查找值
     * @param i
     * @return
     */
    public T get(int i) {
        Node<T> node = head;
        int j = 0;//循环变量, 我们要循环i次，此处j为物理位序，所以以0开头,当j = i 时，刚好循环i次逻辑位序。
        while(j < i && node != null) {//下一个节点可能为null
            j++;
            node = node.next;
        }
        if (node == null) {
            return null;
        } else {
            return node.data;
        }
    }

    //获取某个值
    public int get(T elem) {
        Node<T> node = head;
        int i = 1; //计数
        while (node != null && node.data != elem) {
            node = node.next;
            i++;
        }
        if (node == null) {
            return 0;
        } else {
            return i;
        }
    }

    // 销毁单链表，从头节点开始一个一个释放
    public void destroyList() {
        Node<T> q = head.next;
        while (q != null) {
            head = null; //释放头节点。
            head = q; //下一个节点变为头节点
            q = head.next;
        }
    }

    // 在i位置上插入一个值，这个是逻辑序位，意味着插入后，i位置刚好是这个值。
    public int insert(int i, T elem) {
        int j = 0;
        Node<T> p = head;//头节点不算到序位里。
        i--; //转化为物理序位
        while (j < i && p.next != null) {
            j++;
            p = p.next;
        }
        if (p == null) {
            return 0;//未找到逻辑序位为i-2的节点。即i-1位置上没有值。
        } else {
            Node<T> node = new Node<>();//新建节点
            node.data = elem;
            node.next = p.next;
            p.next = node;
            return 1;
        }
    }

    //删除数据元素
    public int delete(int i) {
        int j = 0;
        Node<T> p = head;
        i--;
        while (j < i && p.next != null) {
            j++;
            p = p.next;
        }
        if (p == null) {//p是删除节点的前一个节点。
            return 0;
        } else {
            Node<T> q = p.next;//q指向要删除的节点。
            if (q == null) {
                return 0;
            }
            p.next = q.next;
            q = null;
            return 1;
        }
    }
}
