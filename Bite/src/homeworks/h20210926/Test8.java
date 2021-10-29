package homeworks.h20210926;

/*
844. 比较含退格的字符串 - https://leetcode-cn.com/problems/backspace-string-compare/
 */

import java.util.Stack;

public class Test8 {
    public static Stack<Character> stringToStack(String s) {
        Stack<Character> characterStack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= 'z' && chars[i] >= 'a') {
                characterStack.push(chars[i]);
            } else {
                if (!characterStack.isEmpty())
                    characterStack.pop();
                //如果是空栈就不操作
            }
        }
        return characterStack;
    }
    public boolean backspaceCompare(String s, String t) {
        /*
        1.和波兰表达式类似。
        2.创建一个栈(数组也可以完成相同的操作)。用于存储字符
        3.1遍历第一个字符串，如果元素是小写字母就入栈，是#就出栈(空栈时就不操作)
        3.2数组：是字母就存到数组中，是#就将i-1元素置空并将i--;
        4.第二个字符串同样的操作(可以采用同一个方法完成两个字符串).
        5.1同时出栈，遇到不同的元素false，结束出栈后有非空栈返回false
        5.2最后将两个数组在一个for循环(循环长度为两数组中最长的那个，防止有长度不同的情况)中出栈，遇到不同的元素就返回false
         */
        Stack<Character> characterStack1 = new Stack<Character>();
        Stack<Character> characterStack2 = new Stack<Character>();
        characterStack1 = stringToStack(s);
        characterStack2 = stringToStack(t);
        while (!characterStack1.isEmpty() && !characterStack2.isEmpty()) {
            if (characterStack1.pop() != characterStack2.pop())
                return false;
        }
        if (!characterStack1.isEmpty() || !characterStack2.isEmpty())
            return false;
        return true;
    }
}
