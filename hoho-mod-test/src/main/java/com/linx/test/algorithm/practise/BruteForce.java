package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqString;

/**
 * BF算法，亦称简单匹配算法。
 */
public class BruteForce {

    public static int index(SqString s, SqString t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.data[i] == t.data[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;// i回到原点，然后加1。即回溯。
                j = 0; //j也复原
            }
        }
        if (j >= t.length()) {//个人觉得j不可能大于t.length
            return i - t.length();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int index = BruteForce.index(new SqString("cddcdc"), new SqString("cdc"));
        System.out.printf("匹配到位置：%s", index);

        int index2 = BruteForce.index(new SqString("ababcabcacbab"), new SqString("abcac"));
        System.out.printf("匹配到位置：%s", index2);
    }
}
