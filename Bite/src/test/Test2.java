package test;

/*
如果LinkedList 、 Stack 为空，则peek()返回什么？
答案：返回null，而pop()会报错。
 */

import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.peek());
        System.out.println(linkedList.pop());
    }
}
