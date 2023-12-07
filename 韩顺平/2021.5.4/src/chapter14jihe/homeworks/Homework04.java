package chapter14jihe.homeworks;

/*
    HashSet：
        通过hash值的到 p 即 table上的位置，首先判断该位置上是否为null，如果是null，直接添加。
    如果不是，就判断改位置上的对象的 hash 和 载入因子是否相同，并且是否是同一对象[equals]。
    如果不是，就判断 该链表是否已经树化，如果树化，按照树化的步骤来
    如果没有树化，就遍历这条链表，直到末尾，如果都没有找到hash值同且equals的对象，就添加到链表尾部。
    TreeSet：
    如果传入了匿名内部类对象Comparator，就使用传入的Comparator匿名内部类对象的compare()方法去重：
    如果返回值 = 0；就认为是相同的元素/数据，不添加。如果没有传入Comparator匿名内部类对象，则以
    添加的对象 实现的Comparable接口的compareTo()方法 去重



 */

import java.util.TreeSet;

public class Homework04 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("hsp");
        treeSet.add("tom");
        treeSet.add("king");
        treeSet.add("hsp");//加入不了
        System.out.println(treeSet);
    }
}

