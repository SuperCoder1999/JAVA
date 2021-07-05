package chapter15genetic.generic;
import java.util.ArrayList;
import java.util.List;

/*
    一：泛型的继承和通配符 <?> 就叫通配符
    1. 泛型没有继承性 错误： List<Object> list = new ArrayList<String>();
        【对比继承示例  Object o = new String("xx");】
    2. <?>  ，可以接受任意的泛型类型
    3. <? extends AA> ： 表示 上限，可以接受 AA或者AA子类
    4. <? super AA> : 支持AA类以及AA类的父类，直接父类也可以，规定了下限
 */

public class GenericExtends {
    public static void main(String[] args) {

        Object o = new String("xx");

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();

        //举例说明下面三个方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //如果是 List<?> c ，可以接受任意的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA> c： 表示 上限，可以接受 AA或者AA子类
//        printCollection2(list1);//×
//        printCollection2(list2);//×
        printCollection2(list3);//√
        printCollection2(list4);//√
        printCollection2(list5);//√

        //List<? super AA> c: 支持AA类以及AA类的父类，直接父类也可以
        printCollection3(list1);//√ Object
        //printCollection3(list2);//×
        printCollection3(list3);//√ AA
        //printCollection3(list4);//×
        //printCollection3(list5);//×

        printCollection4(list1);// √  Object
        //printCollection4(list2);//×   String
        printCollection4(list3);// √  AA
        printCollection4(list4);// √    BB
        //printCollection4(list5);//×     CC


        //冒泡排序

        //插入排序

        //....


    }

    //说明: List<?> 表示 任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object object : c) { // 通配符，取出时，就是Object
            System.out.println(object);
        }
    }
    // ? extends AA 表示 上限，可以接受 AA或者AA子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }


    // ? super 子类类名AA:支持AA类以及AA类的父类，不限于直接父类，
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    public static void printCollection4(List<? super BB> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}