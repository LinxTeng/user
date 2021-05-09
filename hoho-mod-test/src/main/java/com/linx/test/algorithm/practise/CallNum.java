package com.linx.test.algorithm.practise;

import com.linx.test.algorithm.collection.SqQueue;
import org.omg.CORBA.Object;

/**
 * 报数问题
 */
public class CallNum {

    void number(int n) {
        //将所有数字依次放入到队列中
        SqQueue<Integer> q = new SqQueue<>(10);
        q.front = q.rear = 0;
        for (int i = 1; i <= n ; i++) { //构建初始队列
            q.rear = (q.rear + 1) % q.maxSize;
            q.data[q.rear] = i;
        }

        while (q.front != q.rear) { //队列不为空时循环
            for (int j = 0; j < 2 && q.front != q.rear; j++) { //连续出队两个，第一个输出，第二个加入到队尾
                q.front = (q.front + 1) % q.maxSize;
                if (j == 0) {
                    System.out.println(q.data[q.front] + "");
                } else {
                    q.rear = (q.rear + 1) % q.maxSize;
                    q.data[q.rear] = q.data[q.front];
                }
            }
        }
    }

    //约塞夫问题

    /**
     * 有n个数，从第一个数开始, 数到m的数出列，直到n个数都出列为止
     * @param n
     * @param m
     */
    public static void josephus(int n, int m) {
        int[] p = new int[n];

        for (int i = 0; i < n ; i++) {
            p[i] = i + 1;
        }

        int t = 0;
        for (int length = n; length >= 1; length-- ) {
            t = (t + m - 1) % length;//每走m步就移除一个数.length是队列长度。t是编号。
            System.out.print(p[t] + ", ");
            for (int j = t; j < length - 1; j++) {
                p[j] = p[j + 1];//把后面的数往前移
            }
        }
    }

    public static void main(String[] args) {
//        new CallNum().number(9);
         CallNum.josephus(8, 4);
    }
}
