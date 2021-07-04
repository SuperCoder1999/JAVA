package chapter14jihe.map_.hashmap;

import java.util.HashMap;
import java.util.Objects;

/*
    利用代码模拟HashMap触发扩容、树化情况
 */

@SuppressWarnings({"all"})
public class HashMapSource2AddCase {
    public static void main(String[] args) {


        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 12; i++) {
            hashMap.put(i, "hello");
        }
            //加到9时仅仅会进行扩容table(16->32->64)
            //加到11时，table中该位置的链表上的存储类型均变成HashMap$TreeNode
        hashMap.put("aaa", "bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v

        //布置一个任务，自己设计代码去验证，table 的扩容
        //0 -> 16(12) -> 32(24) -> 64(64*0.75=48)-> 128 (96) ->
        //自己设计程序，验证-》 增强自己阅读源码能力. 看别人代码.
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    //所有的A对象的hashCode都是100 -- 这样添加的所有对象，都会找到同一个table位置
//    @Override
//    public int hashCode() {
//        return 100;
//    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
