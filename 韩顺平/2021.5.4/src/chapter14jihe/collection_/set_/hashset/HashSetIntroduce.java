package chapter14jihe.collection_.set_.hashset;
import java.util.HashSet;
import java.util.Set;

/*
    一：HashSet的说明：
    1. HashSet实现了Set接口
    2. HashSet实际上是HashMap，底层源码是这么走的
    3. 可以存放null值，但是只能有一个null
    4. HashSet不保证元素是有序的，取决于hash(一种算法)后，再确定索引的结果。（即不保证
    存放元素的顺序和取出元素的顺序一致)
    5. 不能有重复元素/对象。
 */

public class HashSetIntroduce {
    public static void main(String[] args) {
        //老韩解读
        //1. 构造器走的源码
        /*
            public HashSet() {
                map = new HashMap<>();
            }
         2. HashSet 可以存放null ,但是只能有一个null,即元素不能重复
         */
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        System.out.println("hashSet=" + hashSet);


    }
}