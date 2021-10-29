package Classroom.c20210927;

import java.util.Stack;

/**
 * 完成OJ 20. 有效的括号 - https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Test1 {
    public static void main(String[] args) {

    }

    /*
    1.采用入栈出栈的方式解决
    2.先将字符串变为字符数组。遍历字符数组，核心代码：如果栈顶元素和当前遍历的字符
    匹配则出栈，并且遍历下一个字符。
    3.如果不匹配就入栈。当然判断栈顶前判断是否为空，为空则直接入栈。
    4.最终栈空返回true
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            switch (ch) {
                case ')':
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(ch);
                    break;
                case '}':
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        stack.push(ch);
                    break;
                case ']':
                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        stack.push(ch);
                    break;
                default:
                    stack.push(ch);
                    break;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}

/**
 * 乐扣上评论区看到的方法。是另一种匹配思维。
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}