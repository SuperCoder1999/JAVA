package homeworks.h20210926;

import java.util.ArrayList;
import java.util.Stack;

/*
    JZ21 栈的压入、弹出序列 - https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&&tqId=11174&rp=1&ru=/activity/oj&qru=/ta/coding-interviews/question-ranking
 */

public class Test6 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(arr1, arr2));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        /*
        1.创建一个栈，将第一个序列进行压栈操作。每压栈一次，判断第二个序列指针指的元素
        是否和栈顶值相同，相同就要出栈。第二个序列指针后移，继续判断栈顶值(先排除空栈情况)
        2.如果指针指到最后一个元素的后面，则第二个序列遍历完毕，此时判断第一个序列是否还有
        元素剩余，如果有剩余则false
         */

        Stack<Integer> integerStack = new Stack<Integer>();
        int cur = 0;
        int index = 0;
        while (cur < pushA.length) {
            integerStack.push(pushA[cur]);
            cur++;
            while (!integerStack.isEmpty() && integerStack.peek() == popA[index]) {
                    integerStack.pop();
                    index++;
            }
        }
        if (cur == pushA.length)
            return true;
        else
            return false;
    }
}