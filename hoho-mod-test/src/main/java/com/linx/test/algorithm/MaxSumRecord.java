package com.linx.test.algorithm;


public class MaxSumRecord {

    /** 算法一
     * 求最大连续子序列。
     * 思路：分而治之。先求取左边最大序列，再求取右边最大序列,然后以中心点为起点，向左向右求取最大序列，这两个最大序列之后为中间的最大序列。
     */
    private static int maxSumRecord(int[] a, int left, int right) {
        // 基准情形
        if (left == right) {
            if (a[left] > 0) {
                return a[left];//只有一个元素时，如果它不是负数，那么它就是最大子序。
            } else {
                return 0;
            }
        }
        int center = (left + right) / 2;//二分
        // 计算中间值
        //计算左边
        int maxValueLeft = 0;
        int valueTotalLeft = 0;
        for (int i = center; i >= left; i --) {
            valueTotalLeft += a[i];
            if (valueTotalLeft > maxValueLeft) {
                maxValueLeft = valueTotalLeft;
            }
        }
        //计算右边
        int maxValueRight = 0;
        int valueTotalRight = 0;
        for (int i = center + 1; i <= right; i ++) {
            valueTotalRight += a[i];
            if (valueTotalRight > maxValueRight) {
                maxValueRight = valueTotalRight;
            }
        }

        int maxRecordLeft = maxSumRecord(a, left, center);
        int maxRecordRight = maxSumRecord(a, center + 1, right);
        return Math.max(Math.max(maxRecordLeft, maxRecordRight), maxValueLeft + maxValueRight);
    }

    // 算法二


    public static void main(String[] args) {
        int[] a = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(MaxSumRecord.maxSumRecord(a, 0, a.length -1));
    }

}
