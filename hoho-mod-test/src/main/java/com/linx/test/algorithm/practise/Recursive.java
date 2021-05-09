package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqString;

/**
 * 递归的练习
 */
public class Recursive {
    /**
     * 求A中i之前的最小值
     * @param A
     * @param i
     * @return
     */
    float f(float[] A, int i) {
        if (i == 0) {
            return A[0];
        } else {
            float m = f(A, i -1);
            if (A[i] > m) {
                return m;
            } else {
                return A[i];
            }
        }
    }

    SqString invert(SqString s) {
        SqString r = new SqString();
        if (s.length() == 1) {
            return s;
        } else {
            SqString s1 = invert(s.subStr(2, s.length() -1));
            return s1.concat(s.subStr(1, 1));
        }
    }

    public static void main(String[] args) {
        new Recursive().invert(new SqString("abcdf")).display();
    }
}
