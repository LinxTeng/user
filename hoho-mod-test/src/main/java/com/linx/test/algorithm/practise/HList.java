package com.linx.test.algorithm.practise;

/**
 * 链表和数组结合，用来表示行列式。本类表示：两个行列式进行关联得到关联后的行列式
 */
public class HList {
    int row, col;
    Node head;

    public static class Node {
        int[] data;
        Node next;

        public Node(int i) {
            data = new int[i];
        }
        public Node() {
        }
    }

    public HList() {
        row = 0; col = 0;
        head = new Node();
        head.next = null;
    }

    public HList(int[][] h) {
        head = new Node();
        row = h.length; col = h[0].length;
        Node r = head.next = null;
        for (int i = 0; i < h.length; i++) {
            Node s = new Node();
            s.data = h[i];
            if (r == null) {//头节点
                head.next = s;
            } else {
                r.next = s;
            }
            r = s;
        }
        r.next = null;
    }

    /**
     * 展示
     */
    public void display() {
        Node p = head.next;
        while (p != null) {
            for (int i = 0; i < col; i++) {
                System.out.print(p.data[i] + " ");
            }
            System.out.println("");
            p = p.next;
        }
    }

    /**
     * 返回
     * @param a
     * @param b
     */
    public static HList linkTable(HList a, HList b, int i , int j) {
        Node p, q;
        HList h = new HList();
        h.row = 0;
        h.col = a.col + b.col;
        Node r = h.head;//尾节点。

        p = a.head.next;//获取头节点
        while (p != null) {
            q = b.head.next;
            while (q != null) {
                if (p.data[i] == q.data[j]) {
                    Node s = new Node(h.col);
                    for (int k = 0; k < p.data.length; k++) {
                        s.data[k] = p.data[k];
                    }
                    for (int k = 0; k < q.data.length; k++) {
                        s.data[k + a.col] = q.data[k];
                    }
                    r.next = s;
                    r = s;
                    h.row++;
                }
                q = q.next;
            }
            p = p.next;
        }
        r.next = null;
        return h;
    }

    public static void main(String[] args) {
        int[][] value1 = {{1, 2, 3}, {2, 3, 3}, {1, 1, 1}};
        HList h1 = new HList(value1);

        int[][] value2 = {{3, 5}, {1, 6}, {3, 4}};
        HList h2 = new HList(value2);

        HList hList = HList.linkTable(h1, h2, 2, 0);
        hList.display();
    }
}
