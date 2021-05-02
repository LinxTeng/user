package com.linx.test.algorithm.collection;

import java.security.InvalidParameterException;

/**
 * 顺序表.
 * 存储结构包括：数组存储 和 链表存储。
 */
public class SqList<T> {
   public T[] data;
   public int length;

   public SqList(T[] data) {
       this.data = data;
       this.length = data.length;
   }
    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 线性表长度
     * @return
     */
    public int length() {
        return length;
    }

    /**
     * 输出线性表
     */
    public void display() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.printf("%s ", data[i]);
        }
    }

    /**
     * 线性表中某个数据元素值
     * @param i
     * @return
     */
    public T get(int i) {
        if (i < 1 || i > length) {
            throw new InvalidParameterException("超过列表长度");
        }
        return (T) data[i - 1];
    }

    public int set(int i, T element) {
        if (i < 1 || i > length) {
            throw new InvalidParameterException("超过列表长度");
        }
        data[i] = element;
        return 1;
    }

    /**
     * 按元素值查找
     * @param element
     * @return
     */
    public int locate(T element) {
        int i = 0;
        while(i < length && !data[i].equals(element)) i ++;
        if (i >= length) {
            return 0;
        } else {
            return i + 1;
        }
    }

    public int add(T element) {
       return insert(length + 1, element);//末尾添加
    }

    /**
     * 插入数据元素
     */
    public int insert(int i, T element) {
       if (i < 1 || i > length + 1) {
           return 0;
       }
       i--; //将顺序表逻辑位序转化为物理位序
       for (int j = length; j > i; j--) {
           data[j] = data[j - 1];//把左边的元素复制到右边
       }
       data[i] = element;
       length ++;
       return 1;
    }

    /**
     * 删除元素
     */
    public int delete(int i) {
        if (i < 1 || i > length) {
            return 0;
        }
        i--; //将顺序表逻辑位序转化为物理位序
        for (int j = i; j < length - 1; j++) {
            data[j] = data[j + 1];//把右边的元素复制到左边
        }
        length--;
        return 1;
    }
}
