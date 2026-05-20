package com.zhangrui.algorithms;

import java.util.Stack;

/**
 *
 *
 * @author zhangrui
 * @date 2026/5/19 14:19
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //左括号，入栈
            char c = s.charAt(i);
            if (c == '{' || c== '[' || c== '(') {
                stack.push(c);
            } else {
                //右括号，出栈
                if (!stack.isEmpty() && left(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char left(char c) {
        if (c == '}') {
            return '{';
        } else if (c == ']') {
            return '[';
        } else {
            return '(';
        }
    }

}
