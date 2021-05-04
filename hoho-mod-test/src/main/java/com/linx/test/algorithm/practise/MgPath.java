package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqStack;

/**
 * 求解迷宫问题
 */
public class MgPath {
    int[][] mg = { //迷宫
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    Node[] st;//定义了一个栈，用来存放方块
    int top = -1;

    MgPath() {
        st = new Node[100];
        for (int i = 0; i < st.length; i++) {
            st[i] = new Node();
        }
    }

    /**
     * 定义格子的数据结构
     */
    public static class Node{
        public int i;//当前方块的行号
        public int j;//当前方块的列号
        public int di;//di是下一可走相邻方位的方位号
    }

    public int mgPath(int xi, int yi, int xe, int ye) { //求解路径：(xi, yi)->(xe, ye)
        //将第一个方块放入栈中
        top++;
        Node[] a = st;
        st[top].i = xi; st[top].j = yi;
        st[top].di = -1;
        mg[xi][yi] = -1;
        while (top > -1) {//栈不为空时循环
            //取栈顶方块
            int i = st[top].i; int j = st[top].j; int di = st[top].di;

            if (i == xe && j == ye) {//如果为出口，则输出所有
                System.out.println("迷宫的路径如下:");
                for (int s = 0; s <= top; s++) {
                    System.out.print("(" + st[s].i + "," + st[s].j + ")");
                    if ((s + 1) % 5 == 0) {
                        System.out.print("\n");
                    }
                }
                return 1;
            }

            int k = 0, m = 0;
            int find = 0;
            while (di < 4 && find == 0) {//每个格子遍历四个方向
                di++;
                switch (di) {
                    case 0:
                        k = st[top].i -1; m = st[top].j; break;//这里只是退出swith不是退出循环
                    case 1:
                        k = st[top].i; m = st[top].j + 1; break;
                    case 2:
                        k = st[top].i + 1; m = st[top].j; break;
                    case 3:
                        k = st[top].i ; m = st[top].j - 1; break;
                }
                if (mg[k][m] == 0) {
                    find = 1;
                }
            }

            if (find == 1) {//可走
                //进栈
                st[top].di = di;
                top++;
                st[top].i = k; st[top].j = m; st[top].di = -1;

                // 进栈的方块设置为不可走，防止回溯时的死循环
                mg[k][m] = -1;
            } else {//四个方向都不可走，当前节点退栈, 并恢复可走
                mg[i][j] = 0;
                top--;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new MgPath().mgPath(1, 1, 8, 8);
    }
}
