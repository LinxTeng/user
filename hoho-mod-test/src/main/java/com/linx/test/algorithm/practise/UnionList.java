package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqList;

/**
 * 将两个顺序表组合成另外一个顺序表
 */
public class UnionList {

    public static void main(String[] args) {
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
}
