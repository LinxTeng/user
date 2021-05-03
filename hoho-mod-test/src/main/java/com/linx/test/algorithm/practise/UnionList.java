package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.LkList;
import com.linx.test.algorithm.collection.SqList;

/**
 *
 */
public class UnionList {

    /**
     * 将两个顺序表组合成另外一个顺序表
     * 时间复杂度O(n + m)
     *
     */
    public static void unionList1() {
        Integer[] value1 = {1, 2, 5, 6, 8, 9};
        SqList<Integer> a = new SqList<>(value1);

        Integer[] value2 = {3, 4, 7, 10};
        SqList<Integer> b = new SqList<>(value2);

        SqList<Integer> c = new SqList<>(10);

        int i = 0; int j = 0;
        while (i < a.length && j < b.length) {
            if ((Integer) a.data[i] < (Integer) b.data[j]) {
                c.add((Integer) a.data[i]);
                i++;
            } else if ((Integer) a.data[i] > (Integer) b.data[j]) {
                c.add((Integer) b.data[j]);
                j++;
            }
        }
        while (i < a.length) {
            c.add((Integer) a.data[i]);
            i++;
        }
        while (j < b.length) {
            c.add((Integer) b.data[j]);
            j++;
        }
        c.display();
    }

    /**
     * 已知三个单链表LA,LB,LC中的结点自小到大排列(每个单链表不存在相同的结点，但三个链表中可能存在相同的结点)。求：操作后的链表LA中仅留下
     * 3个表中均包含的数据元素的结点
     * 时间复杂度O(m + n + p)
     */
    public void union2() {
        Integer[] value1 = {1, 2, 5, 6, 8, 9};
        LkList<Integer> a = new LkList<>(value1);

        Integer[] value2 = {2, 3, 5, 7, 8};
        LkList<Integer> b = new LkList<>(value2);

        Integer[] value3 = {2, 6, 8, 9, 10};
        LkList<Integer> c = new LkList<>(value3);

        LkList.Node<Integer> pa = a.head.next;
        LkList.Node<Integer> pb = b.head.next;
        LkList.Node<Integer> pc = c.head.next;

        a.head.next = null; //LA作为新建单链表的头结点
        LkList.Node<Integer> r = a.head; //r指向尾结点。

        while (pa != null) {
            while (pb != null && pa.data > pb.data) {
                pb = pb.next;
            }
            while (pc != null && pa.data > pc.data) {
                pc = pc.next;
            }
            if (pb != null && pc!= null && pa.data == pb.data && pa.data == pc.data) {
                r.next = pa;
                r = pa;
            } else {
                LkList.Node<Integer> q = pa;
                q = null;//java中应该没用
            }
            pa = pa.next;
        }
        r.next = null;

        //打印
        a.display();
    }

    public static void main(String[] args) {
        new UnionList().union2();
    }
}
