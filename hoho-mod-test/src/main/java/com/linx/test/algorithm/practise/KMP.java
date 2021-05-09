package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqString;

/**
 * 串的模式匹配-KMP算法
 */
public class KMP {

    public void kmpIndex(SqString s, SqString t) {

        int i = 0;
        int j = 0;
        int[] next = getNext(t);
        while (i < s.length() && j < t.length()) {
            if (s.data[i] == t.data[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
    }

    /**
     * 计算模式串中j位置之前最大的子串。
     *
     *
     * @param t
     * @return
     */
    private int[] getNext(SqString t) {
        int[] next = new int[100];

        int j = 0;
        int k = -1; //k代表子串的最大长度
        next[0] = -1;
        while (j < t.length() - 1) {
            if (k == -1 || t.data[j] == t.data[k]) {
                j++;
                k++;
                next[j] = k; //next数组的理解：第j个位置之前, 与头结点匹配的串数是k。
            } else {
                k = next[k]; //k是最大串数，这个串里面也可能包含与头节点匹配的串数，那么模式串直接右移到next[k]去比较即可。
            }
        }
        return next;
    }

    public static void main(String[] args) {
        new KMP().getNext(new SqString("abdabeab"));
    }
}
