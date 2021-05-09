package com.linx.test.algorithm.collection;

/**
 * 链串
 *
 * 技巧：
 * 1、先定位，后操作。
 * 2、按位置的增删操作依赖入参的校验
 */
public class LkString {
    Node head;

    public static class Node{
        char data;
        Node next;
    }

    public LkString() {
        head = new Node();
        head.next = null;
    }

    /**
     * 将字符常量赋值给串
     * @param csTr
     */
    void assign(char[] csTr) {
        Node r = head;
        for (int i = 0; csTr[i] != '\0'; i++) {
            Node p = new Node();
            p.data = csTr[i];
            r.next = p;
            r = p;
        }
        r.next = null;
    }

    /**
     * 将串t赋值给s
     * @param t
     */
    void copy(LkString t) {
        Node r = head;
        Node p = t.head.next;
        while (p != null) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        r.next = null;
    }

    /**
     * 判断串相等
     * @param t
     * @return
     */
    boolean equal(LkString t) {
        Node r = head.next;
        Node p = t.head.next;

        while (r != null && p != null && r.data == p.data) {
            r = r.next;
            p = p.next;
        }
        if (r != null || p != null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 求长度
     * @return
     */
    int length() {
        int i = 0;
        Node p = head.next;
        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    /**
     * 串连接。
     * @param t
     * @return
     */
    LkString concat(LkString t) {
        LkString str = new LkString();
        Node r = str.head;

        Node p = head.next;while (p != null) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        p = t.head.next;
        while (p != null) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        r.next = null;
        return str;
    }

    /**
     * 求子串
     * @param i
     * @param j
     * @return
     */
    LkString subStr(int i, int j) {
        LkString str = new LkString();
        Node r = str.head;

        if (i < 0 || i > length() || j < 0 || i -1 + j > length()) {//参数校验
            return null;
        }
        Node p = head.next;
        for (int k = 0; k < i - 1; k++) { //先定位到具体节点。
            p = p.next;
        }
        for (int k = 1; k <= j; k++) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;
        }
        r.next = null;
        return str;
    }

    /**
     * 将串s2插入到串s1的第i个字符位置
     *
     * @param i
     * @param t
     * @return
     */
    LkString insStr(int i, LkString t) {
       LkString str = new LkString();
       Node r = str.head;

       if (i < 0 || i > length() + 1) {
           return null;
       }
       Node p = head.next;
       for (int k = 0; k < i - 1; k++) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;
       }
       Node p1 = t.head.next;
       while (p1 != null) {
           Node q = new Node();
           q.data = p1.data;
           r.next = q;
           r = q;
           p1 = p1.next;
       }
       while (p != null) {
           Node q = new Node();
           q.data = p.data;
           r.next = q;
           r = q;

           p = p.next;
       }
       r.next = null;
       return str;
    }

    /**
     * 从串中删除
     *
     * @param i
     * @param j
     * @return
     */
    LkString delStr(int i, int j) {
        LkString str = new LkString();
        if (i < 0 || i > length() || j < 0 || i -1 + j > length()) {//参数校验
            return null;
        }
        Node r = str.head;

        Node p = head.next;
        for (int k = 0; k < i - 1; i++) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        for (int k = 1; k < j; k++) {//跳过j个节点
            p = p.next;
        }
        while (p != null) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        r.next = null;
        return str;
    }

    /**
     * 替换
     * @param i
     * @param j
     * @param t
     * @return
     */
    LkString repStr(int i, int j, LkString t) {
        LkString str = new LkString();
        if (i < 0 || i > length() || j < 0 || i -1 + j > length()) {//参数校验
            return null;
        }
        Node r = str.head;

        Node p = head.next;
        for (int k = 0; k < i - 1; k++) { //定位到i
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        for (int k = 1; k <= j; k++) {//跳过j个节点
            p = p.next;
        }
        Node p1 = t.head.next;
        while (p1 != null) {
            Node q = new Node();
            q.data = p1.data;
            r.next = q;
            r = q;

            p1 = p1.next;
        }

        while (p != null) {
            Node q = new Node();
            q.data = p.data;
            r.next = q;
            r = q;

            p = p.next;
        }
        r.next = null;
        return str;
    }

    /**
     * 输出串
     */
    void display() {
        Node p = head.next;
        while (p != null) {
            System.out.printf("%s", p.data);
            p = p.next;
        }
    }

    /**
     * 将最先出现的子串"ab"替换成"xyz"
     * @param str
     */
    public static void Rep(LkString str) {
        Node p = str.head.next;

        while (p.next != null) {
            if (p.data == 'a' && p.next.data == 'b') {
                p.data = 'x'; p.next.data = 'z';
                Node q = new Node();
                q.data = 'y';
                q.next = p.next;
                p.next = q;
                return;
            }
            p = p.next;
        }
    }
}
