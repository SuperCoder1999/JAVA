package chapter14jihe.map_.hashmap;

/*
    一：HashMap小结
    1. HashMap是Map接口使用频率最高的实现类
    2. HashMap是以key - value对 的形式来存储数据
    3. key不能重复，但是值value可以重复，允许使用key=null,value=null
    4. 如果添加相同的key，则会替换原本的value
        这里底层代码还是put(和HashSetSource中的源码一样)
    5. 和HashSet一样[HashSet底层走的HashMap]，不保证映射的顺序，因为底层是以hash表的方式存储的(jdk8的hashMap底层
    是数组+链表+红黑树)
    6. HashMap没有实现同步，因此是线程不安全的。原因是：方法中没有做同步互斥操作-没有synchronized。

 */

public class Introduce {
}
