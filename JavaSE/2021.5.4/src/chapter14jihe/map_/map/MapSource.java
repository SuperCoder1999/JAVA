package chapter14jihe.map_.map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    MapIntroduce 后记
    8. Map存放数据的key-value示意图，一对k-v是放在一个HashMap$Node中的，又因为Node实现了Entry接口。
    也可以说一对k-v就是一个Entry

    总结：entrySet()  keySet() 和 values() 都是Map实例对象提供的方法，用于转型并遍历
    1. k-v数据还是保存在HashMap$Node中，只是为了便于遍历，将一对k-v向上转型Entry类型。[HashMap$Node实现了Entry]
    再将Entry类型放入entrySet的集合中。便于遍历.entry.getClass() 输出就是 HashMap$Node (运行类型或者叫内存地址)
    2. 同理，Set keySet() 和 Collection values() 集合是为了将Map中所有的Key和Value分别存储而创建的

 */

@SuppressWarnings({"all"})
public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1", "韩顺平");//k-v
        map.put("no2", "张无忌");//k-v
        map.put(new Car(), new Person());//k-v

        //解读
        //1. k-v 最后是 HashMap$Node node = newNode(hash, key, value, null)
        //2. k-v 为了方便程序员的遍历，还会 创建 EntrySet 集合 ，该集合存放的元素的类型 Entry, 而一个Entry
        //   对象就有k,v EntrySet<Entry<K,V>> 即： transient Set<Map.Entry<K,V>> entrySet;
        //3. entrySet 中， 定义的类型是 Map.Entry ，但是实际上存放的还是 HashMap$Node
        //   这时因为 static class Node<K,V> implements Map.Entry<K,V>
        //4. 当把 HashMap$Node 对象 存放到 entrySet 就方便我们的遍历, 因为 Map.Entry 提供了重要方法
        //   K getKey(); V getValue();

        Set set = map.entrySet();
        System.out.println(set.getClass());// HashMap$EntrySet
        for (Object obj : set) {

            //System.out.println(obj.getClass()); //HashMap$Node
            //为了从 HashMap$Node 取出k-v
            //1. 先做一个向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-" + entry.getValue() );
        }

        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());


    }
}

class Car {

}

class Person{

}
