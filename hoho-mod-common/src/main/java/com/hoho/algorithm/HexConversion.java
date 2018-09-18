package com.hoho.algorithm;

import java.util.Stack;

public class HexConversion {

    public static void main(String[] args) {
        System.out.println(_10_to_62(10000));
    }

    public static String _10_to_62(long num) {
        String[] value = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "m", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "N", "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder(0);
        int yushu = (int) (num % 62);
        stack.push(value[yushu]);
        long chushu = num / 62;
        if (chushu != 0) {
            stack.push(_10_to_62(chushu));
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
