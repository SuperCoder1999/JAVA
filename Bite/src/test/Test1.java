package test;

/*
Map 中靠 value 取出对象，如果value有重复会怎么样?
答案是不能，只能同各国key 找到 value；
 */

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,2);
        map.put(2,2);
        //System.out.println(map.);
    }
}
