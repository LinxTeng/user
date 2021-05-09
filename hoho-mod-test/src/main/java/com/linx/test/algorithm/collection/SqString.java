package com.linx.test.algorithm.collection;

/**
 * 顺序串
 */
public class SqString {
    int maxSize = 100;
    public char[] data;
    int length;

    public SqString() {
        data = new char[maxSize];
        length = 0;
    }

    public SqString(String str) {
        data = str.toCharArray();
        length = str.length();
    }

    /**
     * 将一个字符串赋值给串s,即生成一个其值等于csTr的串
     * @param csTr
     */
    public void assign(char[] csTr) {
        int i;
        for (i = 0; csTr[i] != '\0'; i++) {
            data[i] = csTr[i];
        }
        length = i;
    }

    /**
     * 将串t复制给串s
     */
    public void copy(SqString t) {
        for (int i = 0; i < t.length; i++) {
            data[i] = t.data[i];
        }
        length = t.length;
    }

    /**
     * 判断串相等的条件：当且仅当两个串的长度相等并且各个对应位置上的字符都相同
     * @param t
     * @return
     */
    public boolean equal(SqString t) {
        if (length != t.length) {
            return false;
        } else {
            for (int i = 0; i < length; i++) {
                if (data[i] != t.data[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 长度
     * @return
     */
    public int length() {
        return length;
    }

    /**
     * 将两个串连起来
     * @param t
     * @return
     */
    public SqString concat(SqString t) {
        SqString str = new SqString();
        str.length = length + t.length;
        for (int i = 0; i < length; i++) {
            str.data[i] = data[i];
        }
        for (int j = 0; j < t.length; j++) {
            str.data[length + j] = t.data[j];
        }
        return str;
    }

    /**
     * 求子串
     * @param i
     * @param j
     * @return
     */
    public SqString subStr(int i, int j) {
        SqString str = new SqString();
        if (i <= 0 || i > length || j < 0 || i + j -1 > length) {
            return null; //位置不正确
        }
        for (int k = i - 1; k < i - 1 + j; k++) {
            str.data[k - ( i - 1)] = data[k]; //固定迁移i-1位
        }
        str.length = j;
        return str;
    }

    /**
     * 将串s2传入到串的第i(1 <= i <= length + 1)个字符中。
     * @param i
     * @param s2
     * @return
     */
    public SqString insStr(int i, SqString s2) {
        if (i <= 0 || i > length + 1) {
            return null;
        }
        SqString str = new SqString();
        for (int j = 0; j < i -1; j++) {
            str.data[j] = data[j];
        }
        for (int j = 0; j < s2.length; j++) {
            str.data[j + (i -1)] = s2.data[j];
        }
        for (int j = i; j < length; j++) {
            str.data[j + s2.length] = data[j];
        }
        str.length = length + s2.length;
        return str;
    }

    /**
     * 从串s中删去第i(1 <= i <= length) 个字符。
     * @param i
     * @param j
     * @return
     */
    public SqString delStr(int i, int j) {
        if (i <= 0 || i > length || i + j > length + 1) {
            return null;//入参不正确
        }
        SqString str = new SqString();
        for (int k = 0; k < i - 1; k++) {
            str.data[k] = data[k];
        }
        for (int k = i -1 + j; k < length; k++) {
            str.data[k - j] = data[k];
        }
        str.length = length - j;
        return str;
    }

    /**
     * 将第i个字符开始的j个字符构成的子串用串t替换。并返回产生的新串。
     * @param i
     * @param j
     * @param t
     * @return
     */
    public SqString repStr(int i, int j, SqString t) {
        if (i <= 0 || i > length || i + j -1 > length) {
            return null;
        }
        SqString str = new SqString();
        for (int k = 0; k < i - 1; k++) {
            str.data[k] = data[k];
        }
        for (int k = 0; k < t.length; k++) {
            str.data[k + i - 1] = t.data[k];
        }
        for (int k = i - 1 + j; k < length; k++) { //技巧: str是从i - 1位置开始移动了t.length个位置。根据 k = i - 1 + j => i - 1 = k - j
            str.data[k - j + t.length] = data[k];
        }
        str.length = length + t.length - j;
        return str;
    }

    /**
     * 输出
     */
    public void display() {
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                System.out.printf("%c", data[i]);
            }
        }
    }

    /**
     * 比较两个字符的大小
     * @param s
     * @param t
     * @return
     */
    public static int StrCmp(SqString s, SqString t) {
        int comLen;
        if (s.length < t.length) {
            comLen = s.length;
        } else {
            comLen = t.length;
        }
        for (int i = 0; i < comLen; i++) {
            if (s.data[i] < t.data[i]) {
                return -1;
            } else if (s.data[i] > t.data[i]){
                return 1;
            }
        }
        if (s.length == t.length) {
            return 0;
        } else if (s.length < t.length) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void longestString(SqString s) {
        int i = 0;
        int maxLength = 0;

        int length = 1;
        int start = 0;
        int index = 0; //记录上一个开始的位置
        while (i < s.length - 1) {
            if(s.data[i] == s.data[i + 1]) {
                i++;
                length++;
            } else {
                i++;
                if (length > maxLength) {
                    maxLength = length;
                    start = index;
                }
                index = i;
                length = 1;
            }
        }
        System.out.println("maxLength=" + maxLength + "从位置：" + start + "开始");
    }

    public static void main(String[] args) {
        SqString.longestString(new SqString("aacccdd"));
    }
}
