package com.linx.test.algorithm.practise;

/**
 * 使用队列进行探索。类似于广度优先遍历算法。
 */
public class MgPathQueue {
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

    Node[] Qu;
    int front;//队首指针
    int rear;//队尾指针

    MgPathQueue() {
        Qu = new MgPathQueue.Node[100];
        for (int i = 0; i < Qu.length; i++) {
            Qu[i] = new MgPathQueue.Node();
        }
        front = -1; //此处是从-1开始
        rear = -1;
    }

    public static class Node{
        int i, j; //当前节点的位置。
        int pre; //前一个节点所在的位置。此处的位置即在data[]中的位置。
    }

    public int mgPath(int xi, int yi, int xe, int ye) { //求解路径：(xi, yi)->(xe, ye)
        rear++;//进队列，此处不是环形队列。入口节点设为队列中的第一个值。
        Qu[rear].i = xi; Qu[rear].j = yi;
        Qu[rear].pre = -1;
        mg[xi][yi] = -1;

        while (front < rear) {  //队列不为空时循环
            front++; //出队一次
            if (Qu[front].i == xe && Qu[front].j == ye) {//出栈的刚好为出口节点，则输出路径
                int k = front;
                do { //输出的是一个倒序
                    int j = k; //获取当前节点pre值，遍历后要设置为一个其他值。
                    k = Qu[k].pre;
                    Qu[j].pre = -1;
                } while (k != 0);
                //正序输出
                int ns = 0;
                for (k = 0; k < Qu.length; k++) {
                    if (Qu[k].pre == -1) {
                        ns++;
                        System.out.print("(" + Qu[k].i + "," + Qu[k].j + ")");
                        if (ns % 5 == 0) {
                            System.out.print("\n"); //每五个输出一行
                        }
                    }
                }

                return 1;
            } else {
                int i = Qu[front].i; //头节点的位置
                int j = Qu[front].j;

                for (int di = 0; di < 4; di++) { //四个方向遍历
                    int k = 0, m = 0;
                    switch (di) {
                        case 0:
                            k = i - 1; m = j;
                            break;
                        case 1:
                            k = i; m = j + 1;
                            break;
                        case 2:
                            k = i + 1; m = j;
                            break;
                        case 3:
                            k = i; m = j -1;
                            break;
                    }
                    if (mg[k][m] == 0) { //找到可走的节点, 并加入到队列中
                        rear++;
                        Qu[rear].i = k;
                        Qu[rear].j = m;
                        Qu[rear].pre = front;

                        mg[k][m] = -1;//防止重复搜索
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new MgPathQueue().mgPath(1, 1, 8, 8);
    }
 }
