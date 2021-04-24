package com.linx.test.algorithm;


public class MaxSumRecord {
    /**
     * 算法一。蛮力算法，作用是：验证下面算法的正确性
     */
    private static int maxSumRecord1(int[] a) {
        int maxSubVaule = 0;
        for (int i = 0; i < a.length; i ++) {
            int subValueTotal = 0;
            for (int j = i; j < a.length; j ++) { //已i开头的子序
                subValueTotal += a[j];
                if (subValueTotal > maxSubVaule) {
                    maxSubVaule = subValueTotal;
                }
            }
        }
        return maxSubVaule;
    }

    /** 算法一
     * 求最大连续子序列。
     * 思路：分而治之。先求取左边最大序列，再求取右边最大序列,然后以中心点为起点，向左向右求取最大序列，这两个最大序列之后为中间的最大序列。
     */
    private static int maxSumRecord2(int[] a, int left, int right) {
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

        int maxRecordLeft = maxSumRecord2(a, left, center);
        int maxRecordRight = maxSumRecord2(a, center + 1, right);
        return Math.max(Math.max(maxRecordLeft, maxRecordRight), maxValueLeft + maxValueRight);
    }

    // 算法二
    private static int maxSubSum4(int[] a) {
        int maxSum = 0, thisSum = 0;
        for (int j = 0; j< a.length; j++) {
            thisSum += a[j];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {4, -3, 5, -2, -1, 2, 6, -2};
        System.out.println(MaxSumRecord.maxSumRecord1(a));
        System.out.println(MaxSumRecord.maxSumRecord2(a, 0, a.length -1));
    }

}
