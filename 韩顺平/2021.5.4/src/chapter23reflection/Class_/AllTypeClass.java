package chapter23reflection.Class_;

import java.io.Serializable;

public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> cls1 = String.class;//外部类、成员内部类、静态内部类、局部、匿名内部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组 class [Ljava.lang.Integer;
        Class<float[][]> cls4 = float[][].class;//二维数组 class [[F
        Class<Deprecated> cls5 = Deprecated.class;//注解
        //枚举
        Class<Thread.State> cls6 = Thread.State.class;
        Class<Long> cls7 = long.class;//基本数据类型
        Class<Void> cls8 = void.class;//void数据类型
        Class<Class> cls9 = Class.class;//Class也有自己的数据类型 class java.lang.Class
        Class<?> cls10 = cls9.getClass();//class java.lang.Class
        ClassLoader bootstrapClassLoader1 = cls9.getClassLoader();//null
        ClassLoader bootstrapClassLoader2 = cls10.getClassLoader();//null


        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
        System.out.println(cls10);
        System.out.println(bootstrapClassLoader1);
        System.out.println(bootstrapClassLoader2);
    }

}
