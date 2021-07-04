package chapter14jihe.collection_;

import java.util.ArrayList;
import java.util.List;

/*
    一：Collection接口实现类的特点
    1. collection实现子类可以存放多个元素，每个元素可以是Object
    2. Collection的实现类中，有些是有序的（List），有些是无序的（SetIntroduce）
    3. Collection接口没有直接的实现子类，是通过它的子类接口Set和List来实现的
        【即一般的实现子类都是以实现Set、List等来间接实现Collection】

    二：Collection接口和常用方法
    1.Collection接口常用方法以 其子类接口List 实现的 ArrayList类来演示
    2. 下面代码均采用向上转型，所以都有动态绑定
        list_.add("jack"); 就是调用的ArrayList的add方法
 */

public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();

//        add:添加单个元素
        list.add("jack");
        list.add(10);//list_.add(new Integer(10))
            //这里有自动装箱的过程，将10装箱为Integer形式。作为元素存入ArrayList集合中
        list.add(true);// 也有自动装箱过程，可能是String类型
        System.out.println("list_=" + list);

//        remove:删除指定元素
        //list_.remove(0);//删除第一个元素
        list.remove(true);//指定删除某个元素
        System.out.println("list_=" + list);

//        contains:查找元素是否存在
        System.out.println(list.contains("jack"));//T

//        size:获取元素个数
        System.out.println(list.size());//2

//        isEmpty:判断是否为空
        System.out.println(list.isEmpty());//F

//        clear:清空
        list.clear();
        System.out.println("list_=" + list);

//        addAll:添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        list.addAll(list2);
        System.out.println("list_=" + list);

//        containsAll:查找多个元素是否都存在
        System.out.println(list.containsAll(list2));//T

//        removeAll：删除多个元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println("list_=" + list);//[聊斋]

    }
}
