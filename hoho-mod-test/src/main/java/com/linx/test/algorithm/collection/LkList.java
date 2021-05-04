package com.linx.test.algorithm.collection;

/**
 * 单链表
 * 注意：新增、删除某个位置的值，p需要指向头节点: p = head，其他指向第一个节点: p = head.next
 *
 * 尾插法的几个要点：
 *   1、首先定义一个尾结点关联头结点
 *   2、然后结点加进来后，移动尾结点到当前结点
 *   3、最后一行尾结点的next需要设置为null
 * @param <T>
 */
public class LkList<T> {
    public Node<T> head; // 头节点

    public static class Node<T> { //链表节点
        public T data;
        public Node<T> next;//后继节点
    }

    public LkList() {//建立一个空链表
        head = new Node<>();
        head.next = null;
    }

    /**
     *
     * 尾插法建表
     * @param list
     */
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

    /** -------------------------------------------------------------------- */
    public void SLkList(T[] list) {
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

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return head.next == null;
    }

    /**
     * 求长度
     * @return
     */
    public int length() {
        Node<T> p = head.next;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }

    /**
     * 输出
     */
    public void display() {
        Node<T> p = head.next;
        while (p != null) {
            System.out.printf("%s ", p.data);
            p = p.next;
        }
    }

    /**
     * 查找值
     * @param i
     * @return
     */
    public T get(int i) {
        Node<T> p = head;
        int j = 0;//循环变量, 我们要循环i次，此处j为物理位序，所以以0开头,当j = i 时，刚好循环i次逻辑位序。
        while(j < i && p != null) {//下一个节点可能为null
            j++;
            p = p.next;
        }
        if (p == null) {
            return null;
        } else {
            return p.data;
        }
    }

    //获取某个值
    public int get(T elem) {
        Node<T> p = head.next;
        int i = 1; //计数
        while (p != null && p.data != elem) {
            i++;
            p = p.next;
        }
        if (p == null) {
            return 0;
        } else {
            return i;
        }
    }

    /** 销毁单链表，从头节点开始一个一个释放
     *
     * 注意：1、头结点不一定说data没有值时才可以为头结点，实际当一个节点不再使用时就可以充当头节点了。也就是说在
     * 链式结构中头结点不是固定不变的。
     * 2、在删除移动时头结点是保持不变的。
    */
    public void destroyList() {
        Node<T> p = head; Node<T> q = head.next;
        while (q != null) {
            p = null; //释放头节点。
            p = q; //下一个节点变为头节点
            q = p.next;
        }
        p = null;
    }

    // 在i位置上插入一个值，这个是逻辑序位，意味着插入后，i位置刚好是这个值。
    public int insert(int i, T elem) {
        int j = 0;
        Node<T> p = head;//头节点不算到序位里。
        i--; //转化为物理序位
        while (j < i && p != null) {
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
        while (j < i && p != null) {
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
            q = null;//释放空间
            return 1;
        }
    }
}
