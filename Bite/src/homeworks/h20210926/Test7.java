package homeworks.h20210926;

/*
682. 棒球比赛 - https://leetcode-cn.com/problems/baseball-game/
 */

import java.util.Stack;

public class Test7 {
    public int calPoints(String[] ops) {
        /*
        1.和波兰表达式计算类似。
        2.创建一个栈(因为没有运算符的优先级等条件，所以至于要一个栈存放数字即可)，用于存放数字。
        3.遍历数组，遇到数字入栈。遇到符号就按照符号含义从栈中取出相应数字进行操作，并将新的结果入栈。
        3.数组遍历结束后，将栈内所有元素出栈相加返回。
         */
        Stack<Integer> integerStack = new Stack<Integer>();
        int index = 0;
        while (index < ops.length) {
            String temp = ops[index];
            switch (temp) {
                case "C":
                    integerStack.pop();//题目中说明了，不会出现栈的情况。
                    break;
                case "D":
                    integerStack.push(2 * integerStack.peek());//没有空栈
                    break;
                case "+":
                    int n1 = integerStack.pop();
                    int n2 = integerStack.peek();
                    integerStack.push(n1);//将n1再入栈
                    integerStack.push(n1 + n2);
                    break;
                default:
                    int n = Integer.parseInt(temp);
                    integerStack.push(n);
                    break;
            }
            index++;
        }
        int sum = 0;
        while (!integerStack.isEmpty()) {
            sum += integerStack.pop();
        }
        return sum;
    }
}
