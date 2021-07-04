package chapter14jihe.collection_.set_.set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    以Set 接口的实现类 HashSet 来讲解Set 接口的方法(这里使用Set对象作为编译类型，所以调用的都是Set的方法。
 */

@SuppressWarnings({"all"})
public class SetMethods {
    public static void main(String[] args) {
        //解读
        //1. 以Set 接口的实现类 HashSet 来讲解Set 接口的方法[编译类型是Set，所以只能调用Set方法]
        //2. set 接口的实现类的对象(Set接口对象), 不能存放重复的元素, 可以添加一个null
        //3. set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
        //4. 注意：取出的顺序的顺序虽然不是添加的顺序，但是他的固定(底层有算法进行排序).
        //5. 底层是数组加链表的形式
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john");//重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null);//
        set.add(null);//再次添加null
        for (int i = 0; i < 10; i++) {
            System.out.println("set=" + set);
        }

        //遍历
        //方式1： 使用迭代器
        System.out.println("=====使用迭代器====");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

        }

        set.remove(null);

        //方式2: 增强for
        System.out.println("=====增强for====");

        for (Object o : set) {
            System.out.println("o=" + o);
        }

        //set 接口对象，不能通过索引来获取


    }
}

