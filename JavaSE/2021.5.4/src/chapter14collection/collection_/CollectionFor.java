package chapter14collection.collection_;

/*
    二：Collection接口遍历对象方式2 - 增强for循环
    1. 增强for循环，可以代替iterator迭代器，特点：增强for就是简化版的iterator，本质一样。
    只能用于遍历集合或数组

    三：基本语法：
    for(元素类型 元素名 : 集合名或数组名) { // 这里的元素类型可以是元素类型的父类
        对访问元素的操作;
    }

 */

import java.util.ArrayList;
import java.util.Collection;


public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));

        //老韩解读
        //1. 使用增强for, 在Collection集合
        //2. 增强for， 底层仍然是迭代器
        //3. 增强for可以理解成就是简化版本的 迭代器遍历
        //4. 快捷键方式 I
//        for (Object book : col) {
//            System.out.println("book=" + book);
//        }
        for (Object o : col) {
            System.out.println("book=" + o);
        }

        //增强for，也可以直接在数组使用
//        int[] nums = {1, 8, 10, 90};
//        for (int i : nums) {
//            System.out.println("i=" + i);
//        }


    }
}
