package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqList;

public class SqListPractise {
    /**
     * 有一个顺序表L,假设元素类型都为整型并且所有元素均不相等。
     * 设计一个算法，以第一个元素为分界线，将所有小于它的元素移到该元素的前面，将所有大于它的元素移动到该元素的后面
     *
     * 时间复杂度：O(n)
     */
    private void move(SqList<Integer> list) {
        Integer pivot = (Integer) list.data[0];
        int i = 0, j = list.length -1;
        while (i != j) {
            while (j > i && ((Integer) list.data[j]) > pivot) { //从右边找到第一个比pivot小的数。此处大于时即进入循环，小于则跳出循环
                j--;
            }
            list.data[i] = list.data[j];
            while (i < j && ((Integer) list.data[i]) < pivot) {//从左边找到第一个比pivot大的数
                i++;
            }
            list.data[j] = list.data[i];// 两个交换
            list.data[i] = pivot;

        }
    }

    public static void main(String[] args) {
        Integer[] num = {3, 5, 6, 1, 4, 2, 7, 9, 8, 0};
        SqList<Integer> list = new SqList<>(num);
        new SqListPractise().move(list);
        list.display();
    }
}
