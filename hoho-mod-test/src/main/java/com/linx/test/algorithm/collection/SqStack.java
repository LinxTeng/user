package com.linx.test.algorithm.collection;

public class SqStack<T> {
    public Object[] data; //数组
    public int top; //栈顶元素

    /**
     * 新建空栈
     * @param i
     */
    public SqStack(int i) {
        this.data = new Object[i];
        top = -1; //空栈指向-1
    }

    /**
     * 进栈
     */
    public int push(T e) {
        top++;
        data[top] = e;
        return 1;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        T e = (T) data[top];
        top--;
        return e;
    }

    /**
     * 求栈的长度
     */
    public int length() {
        return top + 1;
    }

    public boolean isEmpth() {
        return top == -1;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public T getTop() {
        if (top != -1) {
            return null;
        }
        return (T) data[top];
    }

    /**
     * 显示栈中元素: 从栈顶开始打印
     */
    void display() {
        for (int i = top; i > 0; i--) {
            System.out.println(data[i]);
        }
    }

}
