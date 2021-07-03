package chapter14collection.list_.list;

import java.util.ArrayList;
import java.util.List;

/*
    List接口是Collection接口的子接口（这节主要介绍List中特有方法，这些方法可能在set中没有）,
    是LinkedList、ArrayList、Vector的父类接口
 */

public class ListIntroduce {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1. List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复 [案例]
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        list.add("tom");
        System.out.println("list=" + list);// 这条语法就是直接输出集合
        //2. List集合中的每个元素都有其对应的顺序索引，即支持索引
        //   索引是从0开始的
        System.out.println(list.get(3));//hsp
    }
}
