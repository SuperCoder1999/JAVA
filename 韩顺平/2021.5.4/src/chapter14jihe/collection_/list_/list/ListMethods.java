package chapter14jihe.collection_.list_.list;
import java.util.ArrayList;
import java.util.List;

// 以list 接口的实现类 ArrayList 来讲解List 接口的方法(这里使用List对象作为编译类型，所以调用的都是List的方法。

public class ListMethods {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");

//        void add(int index, Object ele):在index位置插入ele元素,index必须小于等于list.size(),即list插入的位置和前面的元素之间没有空隙
        //在index = 1的位置插入一个对象
        list.add(1, "韩顺平");
        System.out.println("list=" + list);

//        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list=" + list);

//        Object get(int index):获取指定index位置的元素
        //package chapter14jihe.list_中的ListDetail文件中有

//        int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));//2

//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        list.add("韩顺平");
        System.out.println("list=" + list);
        System.out.println(list.lastIndexOf("韩顺平"));//5

//        Object remove(int index):移除指定index位置的元素，并返回此元素。
            // 删除元素后,后续元素的下标全部减少1.即元素前移
        list.remove(0);
        System.out.println("list=" + list);
        System.out.println("list=" + list.get(0));
        System.out.println("list=" + list.get(1));

//        Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.
        //不能替换不存在的元素：list.set(5, "玛丽");报错
        list.set(1, "玛丽");
        System.out.println("list=" + list);

//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        // 注意返回的子集合 fromIndex <= subList < toIndex    [x, y) 前开后闭区间
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist=" + returnlist);

        // containsAll:查找多个元素是否都存在

        // removeAll：删除多个元素
        
    }
}