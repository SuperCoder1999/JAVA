package chapter14jihe.collection_.IterateOverCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/19 17:28
 * Description 在遍历时 修改集合,会发生什么
 * 1.Iterator必须通过Iterator.remove()删除
 * 2.forEach内不能删除任何元素
 * 3.for循环中,可以随意删除
 */
public class ChangeListWhenLterating {
    public static void main(String[] args) {
        List<String> list = new LinkedList();
        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add("北京烤鸭子");

        //testFor(list);
        //testForEach(list);
        testIterator(list);
    }

    public static void testForEach(List<String> list) {
        System.out.println("=====增强for=====");
        //2. 增强for -- foreach底层是iterator,由于Fail-Fast机制,任何修改都会报错
        Iterator iterator = list.iterator();
        for (Object o : list) {
            System.out.println("o=" + o);
            // 即使借用别人的iterator也不行,因为foreach有自己的iterator
            //别人调用remove(),修改的是记录在别的iterator那里的记录.还是会报错
            if (o == "tom") {
                iterator.remove();
            }
        }
    }

    public static void testIterator(List<String> list) {
        System.out.println("=====迭代器Iterator=====");
        //1. 迭代器 - 只允许迭代器中提供的修改方法
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
            //list.remove(obj);
        }
    }

    public static void testFor(List<String> list) {
        System.out.println("=====普通for====");
        //3. 使用普通for - 由于每次遍历都是计算list大小,所以修改了也不会报错
        for (int i = 0; i < list.size(); i++) {
            System.out.println("对象=" + list.get(i));
            if (i == 3)
                list.add("123");
        }
    }
}
