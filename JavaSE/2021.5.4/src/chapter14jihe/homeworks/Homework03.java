package chapter14jihe.homeworks;

import java.util.*;

/*
        一：修改map中key、value的内容（set中也同理）
         value - key不是不能直接修改，而是看对象（key-value本质是存放对象的地址）
         存在常量池的对象无法修改，因此只能更换地址
         堆中 有对象示例的，将实例中属性的地址更改了，这样可以不用更改对象在key-value的地址
 */

public class Homework03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);


//         value - key不是不能直接修改，而是看对象（key-value本质是存放对象的地址）
//         存在常量池的对象无法修改，因此只能更换地址
//         堆中 有对象示例的，将实例中属性的地址更改了，这样可以不用更改对象在key-value的地址
        Map map1 = new HashMap();
        Cat cat = new Cat("小花");
        map1.put(cat, 1);

        System.out.println(map1);
        cat.name = "小红";
        System.out.println(map1);

//
//        map.put("jack", 2600);
//
//        Set keySet = map.keySet();
//        Iterator iterator = keySet.iterator();
//        while (iterator.hasNext()) {
////            Object obj = iterator.next();
////            Integer d = (Integer) obj;
////            d += 100; --- 不能在value上直接改   需要更新 key-values
//            Object obj = iterator.next();
//            map.put(obj, (Integer)map.get(obj) + 100);
//        }
//
//        keySet = map.keySet();
//        for(Object obj : keySet) {
//            String s = (String)obj;
//            System.out.println(s);
//        }
//
//        Collection values = map.values();
//        for (Object obj : values) {
//            System.out.println(obj);
//        }
    }
}

class Cat {
    public String name;

    public Cat(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}