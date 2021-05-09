package com.linx.test.algorithm.practise;

/**
 * 皇后问题,n * n的棋盘，放置n个皇后，保证每个皇后不在同一列，同一行，以及同对角线上。这样的摆法有多少种？
 *
 * 技巧：如何判断两个节点处于同一个对角线上：两个节点的横坐标之差的绝对值等于竖坐标之差的绝对值。
 */
public class Queen {
    int[] q = new int[100];
    /**
     * 递归求法。共有n列，在k列的合适位置上放置一个皇后。
     */
    public void place(int k, int n) {
        if (k == 1) { //第一列，随机放置一个皇后。
            q[1] = 3;
            System.out.printf("(%s, %s)", 1, 2);
        } else {
            place(k - 1, n);//在k - 1 列上完成了皇后的放置
            //k列找到一个合理的位置放置皇后。
            for (int i = 1; i <= n; i++) {
                if (find(i, k)) {
                    q[k] = i;
                    System.out.printf("(%s, %s)", k, i);
                }
            }
        }
    }

    private boolean find(int i, int k) {
        int j = 1;
        while (j < k) {
            if (q[j] == i || (Math.abs(q[j] - i) == Math.abs(j - k))) {
                return false;
            } else {
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Queen().place(4, 4);
    }
}
