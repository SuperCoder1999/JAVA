package chapter14jihe.map_.map;
import java.util.*;

/*

    Map接口遍历方式
    1.用到的的方法
    1）containKey:查找键是否存在
    2）keySet：获得所有的键
    3）entrySet：获取所有关系k-v
    4）values：获取所有的值

    二：总结
    1. 第一种和第二种，已经将数据取出来的，所以可以直接输出
    2.第三种是转换为了另一种集合形式，再将该集合拆解成单个对象[Entry元素(本质还是HashMap$Node)]
    每个对象都提供了方法来输出其中的数据
 */

@SuppressWarnings({"all"})
public class MapFor {
    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //第一组: 先取出 所有的Key , 通过Key 取出对应的Value
        Set keyset = map.keySet();//因为取出来后放在了Set集合中，所以不能用普通for循环
            //也可以用Collcetion来向上转型  本质返回Set类型集合 Collcetion keyset = map.keySet();
        //(1) 增强for
        System.out.println("-----第一种方式-------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2) 迭代器
        System.out.println("----第二种方式--------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组: 把所有的values取出。不关心对应关系，值想取出value的情况下适用
            // -- 也可以在keySet中get(key)来间接获取values
        Collection values = map.values();
        //本质返回的是Collection类型的集合
        //这里可以使用所有的Collections使用的遍历方法
        //(1) 增强for
        System.out.println("---取出所有的value 增强for----");
        for (Object value : values) {
            System.out.println(value);
        }
        //(2) 迭代器
        System.out.println("---取出所有的value 迭代器----");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value =  iterator2.next();
            System.out.println(value);

        }
        //(3)普通for循环 values.size()

        //第三组: 通过EntrySet 来获取 k-v
        Set<Map.Entry<Byte, Integer>> entrySet = map.entrySet();// 返回： Set<Map.Entry<K, V>>。// --- 集合那一节需要改进
        //(1) 增强for
        System.out.println("----使用EntrySet 的 for增强(第3种)----");
        for (Map.Entry entry : entrySet) {//-- 因为 这里Map.Entry<>中的泛型确定,所以不用再转换了
            //将entry 转成 Map.Entry
            /*Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());*/
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        //(2) 迭代器
        System.out.println("----使用EntrySet 的 迭代器(第4种)----");
        Iterator iterator3 = entrySet.iterator();
        while (iterator3.hasNext()) {
            Object entry =  iterator3.next();//迭代器默认返回的是Object类型
            //System.out.println(next.getClass());//HashMap$Node -实现-> Map.Entry (getKey,getValue)
            //向下转型 Map.Entry [因为Object 及 HashMap$Node没有提供遍历的方法]
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}