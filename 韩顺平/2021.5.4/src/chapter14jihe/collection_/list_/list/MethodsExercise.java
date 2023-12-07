package chapter14jihe.collection_.list_.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MethodsExercise {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("hello" + i);
        }
        list.add(2, "world");
        System.out.println("获取第五个元素 : " + list.get(4));
        list.remove(5);
        list.set(6, "wode");// 这里可以看到删除后，该位置是空的，后续元素的序号并没有改变

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
