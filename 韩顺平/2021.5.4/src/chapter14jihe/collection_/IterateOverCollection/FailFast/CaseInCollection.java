package chapter14jihe.collection_.IterateOverCollection.FailFast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/19 17:06
 * Description 集合类中的fail-fast
 * 1.原理分析: https://blog.csdn.net/OYMNCHR/article/details/124515536
 * 2.我的总结:
 *  1.foreach遍历删除,调用的了迭代器下方法和ArrayList中自带的remove(Object o)方法
 *   迭代器方法有检测一致性的操作.因为迭代器的目的就是遍历最新的集合数据.而ArrayList的remove(Object o)对在没有通知迭代器的情况下更改了集合
 *  2.迭代器中可以删除数据,不过需要让迭代器知道,所以使用迭代器自带的remove()方法
 *  3.而增强for中无法获得iterator,所以建议直接使用iterator进行遍历
 */
public class CaseInCollection {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList();
        list.add("haha1");
        list.add("haha");
        list.add("haha4");//这个注释掉,就不会报错了,不清楚原因???
        list.add("haha2");

        /*for (String str : list) {
            if (str.equals("haha")) {
                list.remove(str);   //抛出异常
            }
        }*/

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str == "haha") {
                iterator.remove();   //正确做法
            }
        }

        for (String str : list) {
            System.out.println(str);
        }
    }

    public static void testSet() {
        Collection<String> list = new ArrayList();
        list.add("haha1");
        list.add("haha");
        list.add("haha4");//这个注释掉,就不会报错了,不清楚原因???
        list.add("haha2");

        /*for (String str : list) {
            if (str.equals("haha")) {
                list.remove(str);   //抛出异常
            }
        }*/

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str == "haha") {
                iterator.remove();   //正确做法
            }
        }

        for (String str : list) {
            System.out.println(str);
        }
    }
}
