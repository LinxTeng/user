package com.linx.test.algorithm.practise;


import com.linx.test.algorithm.collection.LkStack;
import com.linx.test.algorithm.collection.SqStack;

/**
 * 栈的应用
 * 将中缀表达式转换为后缀表达式。需假定中缀表达式是合法的。
 * 运算规则是：先乘除后加减，从左到右计算，先括号内，后括号外。
 * 比如：a + b * c - d / e  => a b c * + d e / -
 *
 * 思路：右边的运算符如果小于左边的运算符时，需要出栈。出栈意味着会先行计算。也就是说优先级越高越快出栈
 */
public class ExprRevert {
    LkStack<Integer> stack;

    // 定义优先级: 同一个运算符设置左右优先级不同是为了实现："从左到右的计算"
    // lPri代表在栈中的运算符
    char[][] lPri = {{'=', 0}, {'(', 1}, {'+', 3}, {'-', 3}, {'*', 5}, {'/', 5}, {')', 6}};
    // rPri代表在字符串中的运算符
    char[][] rPri = {{'=', 0}, {'(', 6}, {'+', 2}, {'-', 2}, {'*', 4}, {'/', 4}, {')', 1}};

    //　计算左运算符的优先级
    int leftPri(char op) {
        for (int i = 0; i < lPri.length; i++) {
            if (lPri[i][0] == op) {
                return lPri[i][1];
            }
        }
        return 0;
    }
    // 计算右运算符的优先级
    int rightPri(char op) {
        for (int i = 0; i < rPri.length; i++) {
            if (rPri[i][0] == op) {
                return rPri[i][1];
            }
        }
        return 0;
    }
    // 判断是否是运算符
    boolean InOp(char ch) {
        return  (ch == '(' || ch == ')' || ch == '+' || ch == '-' || ch == '*' || ch == '/') ;
    }

    /**
     * 将中缀表达式转换为后缀表达式
     */
    char[] trans(String exprStr) {
        SqStack<Character> op = new SqStack<>(100);
        char[] exp = exprStr.toCharArray();
        char[] postExp = new char[100];

        //最终结果
        //将=号进栈
        op.top++;
        op.data[op.top] = '=';

        int i = 0;
        int j = 0;
        while (exp[j] != ';') {
            char ch = exp[j];
            if (!InOp(ch)) { //不是运算符，将值放入输出队列
                while (exp[j] >= '0' && exp[j] <= '9') {
                    postExp[i++] = exp[j];
                    j++;
                }
                postExp[i++] = '#';
            } else {
                if (leftPri((char)op.data[op.top]) < rightPri(ch)) {//左边的优先级小于右边，则进栈
                    op.top++;
                    op.data[op.top] = ch;
                    j++; //继续扫描
                } else if (leftPri((char)op.data[op.top]) > rightPri(ch)) { //左边的优先级大于右边，需出栈。直到遇到比它小的运算符
                    postExp[i++] = (char) op.data[op.top];
                    op.top--;
                }
                else {//等于的情况，只有栈顶为'(', ch为')'的情况。其他情况不存在，因为')'不可能进栈。需出栈
                    op.top--;//出的其实是'('，所以结果中不会有'('
                    j++; //继续扫描
                }
            }
        }
        while ((char)op.data[op.top] != '=') {//字符串扫描完毕，退栈到 '=' 为止
            postExp[i++] = (char) op.data[op.top];
            op.top --;
        }
        postExp[i++] = ';';
        System.out.println("中缀表达为:" + exprStr);
        System.out.println("后缀表达为:" + String.valueOf(postExp));
        return postExp;
    }

    /**
     * 后缀表达式求值
     * @param postExp
     * @return
     */
    float compValue(char[] postExp) {
        SqStack<Float> st = new SqStack<>(100);//新建一个栈
        float  a = 0, b = 0, c = 0;

        int j = 0;
        while (postExp[j] != ';') {
            char exp = postExp[j];
            switch (exp) {
                case '+': //退栈取两数相加
                    a = (float) st.data[st.top];
                    st.top--;
                    b = (float) st.data[st.top];
                    st.top--;
                    c = b + a;
                    st.top++;
                    st.data[st.top] = c;//结果需要进栈
                    break;
                case '-':
                    a = (float) st.data[st.top];
                    st.top--;
                    b = (float) st.data[st.top];
                    st.top--;
                    c = b - a;
                    st.top++;
                    st.data[st.top] = c;
                    break;
                case '*':
                    a = (float) st.data[st.top];
                    st.top--;
                    b = (float) st.data[st.top];
                    st.top--;
                    c = b * a;
                    st.top++;
                    st.data[st.top] = c;
                    break;
                case '/':
                    a = (float) st.data[st.top];
                    st.top--;
                    b = (float) st.data[st.top];
                    st.top--;
                    if (a != 0) {
                        c = b / a;
                        st.top++;
                        st.data[st.top] = c;
                    } else {
                        System.out.println("除零错误!");
                        throw new RuntimeException("除零错误!");
                    }
                    break;
                case '#':
                    break;//不处理
                default: //处理数字
                    float d = 0;
                    while (postExp[j] >= '0' && postExp[j] <= '9') {
                        d = 10 * d + postExp[j] - '0';//每循环一次，数据就变大10. 即如何顺序地将数字字符转化为真实的数字。
                        j++;
                    }
                    st.top++;
                    st.data[st.top] = d; //将数字进栈
                    break;
            }
            j++;//继续处理其他字符
        }
        System.out.println("计算后的值为:" + st.data[st.top]);
        return (float) st.data[st.top];
    }

    public static void main(String[] args) {
//        new ExprRevert().match();

        char[] test = new ExprRevert().trans("(56-20)/(4+2);");
        new ExprRevert().compValue(test);
    }

    /**
     * 判断表达式中括号是否配对。
     */
    public void match() {
        String str = "1 + (2 * ((3 + 1)))";
        LkStack<Character> stack = new LkStack<>();
        for (char exp : str.toCharArray()) {
            if (exp == '(') {
                stack.push(exp);//进栈
            } else if (exp == ')') {
                Character c = stack.getTop();//获取栈顶元素
                if (c == null) {
                    System.out.println("表达式中括号不匹对");
                    return;
                } else {
                    if ( c != '(') {
                        System.out.println("表达式中括号不匹对");
                        return;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("表达式中括号匹对");
        } else {
            System.out.println("表达式中括号不匹对");
        }
    }
}
