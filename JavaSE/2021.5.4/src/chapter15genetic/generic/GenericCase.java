package chapter15genetic.generic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class GenericCase {
    public static void main(String[] args) {
        //* 1.HashSet
        HashSet<Students> hashSet = new HashSet<Students>();
        hashSet.add(new Students("小米", 10));
        hashSet.add(new Students("小明", 30));
        hashSet.add(new Students("Tom", 12));
        hashSet.add(new Students("Jack", 20));
        //增强for循环遍历
        System.out.println("增强for循环遍历");
        for (Students stu : hashSet) {
            System.out.println(stu.name + "-" + stu.age);
        }

        //* 2.HashMap
        HashMap<String, Students> hashMap = new HashMap<String, Students>();
         /*
            public class HashMap<K,V>  {}
         */
        hashMap.put("小米", new Students("小米", 10));
        hashMap.put("小明", new Students("小明", 30));
        hashMap.put("Tom", new Students("Tom", 12));

        // 迭代器遍历
        Set<Map.Entry<String, Students>> entrySet = hashMap.entrySet();
            // new HashMap<String, Students>();就已经将HashMap<K,V>类名后面的K,V赋值了，
            // 因此这里调用entrySet()方法(如下：)
         /*
        public Set<Map.Entry<K,V>> entrySet() { //因为K,V在上面已经提到被赋值了，因此返回类型就确定了
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        Iterator<Map.Entry<String, Students>> iterator = entrySet.iterator();

        /*
            public final Iterator<Map.Entry<K,V>> iterator() {
            // 因该是Map.Entry<K,V>已经被赋值了。因此这里返回类型是确定的
                return new EntryIterator();
            }
         */
        while (iterator.hasNext()) {
            Map.Entry<String, Students> entry = iterator.next();
            // 这里实际上Map.Entry才是和Dog同级别的,即：
            // 存的时候就是Map.Entry：Set<Map.Entry<String, Students>> entrySet = hashMap.entrySet();
            // ，取出来时Map.Entry<String, Students> entry = iterator.next(); 就不用转型了
            System.out.println(entry.getKey() + "-" + entry.getValue());

        }
    }
}

class Students {
    public String name;
    public int age;

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}