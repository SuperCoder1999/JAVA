package chapter14jihe.map_.hashtable;
import java.util.Hashtable;
/*
    一：HashTable基本介绍
    1. HashTable继承了Dictionary类，实现Map类
    2. 存放的元素时键值对：即k-val
    3. HashTable的键和值都不能为null，否则会抛出NullPointException
    4. HashTable方法和HashMap一样(都实现了Map，也都将Map的抽象类实现了)
    5. HashTable是线程安全的(synchronized)，HashMap不是。
    6. HashTable也是不能保存重复元素

    二.Hashtable的底层
    1. 底层有数组 Hashtable$Entry[] 初始化大小为 11
    2. 临界值 threshold 8 = 11 * 0.75
    3. 扩容: 按照自己的扩容机制来进行即可.
    4. 执行 方法 addEntry(hash, key, value, index); 添加K-V 封装到Entry
    5. 当 if (count >= threshold) 满足时，就进行扩容
    5. 按照 int newCapacity = (oldCapacity << 1) + 1; 的大小扩容.
 */

@SuppressWarnings({"all"})
public class HashtableIntroduce {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();//ok
        table.put("john", 100); //ok
        //table.put(null, 100); //异常 NullPointerException
        //table.put("john", null);//异常 NullPointerException
        table.put("lucy", 100);//ok
        table.put("lic", 100);//ok
        table.put("lic", 88);//替换
        table.put("hello1", 1);
        table.put("hello2", 1);
        table.put("hello3", 1);
        table.put("hello4", 1);
        table.put("hello5", 1);
        table.put("hello6", 1);
        System.out.println(table);

//        简单说明一下Hashtable的底层
//        1. 底层有数组 Hashtable$Entry[] 初始化大小为 11 .载入因子是封装成Entry再放入table，Node也是如此
//        2. 临界值 threshold 8 = 11 * 0.75
//        3. 扩容: 按照自己的扩容机制来进行即可. 原来的大小 乘以2 再加 1
//        4. 执行 方法 addEntry(hash, key, value, index); 添加K-V 封装到Entry
//        5. 当 if (count >= threshold) 满足时，就进行扩容
//        5. 按照 int newCapacity = (oldCapacity << 1) + 1; 的大小扩容.

    }
}
