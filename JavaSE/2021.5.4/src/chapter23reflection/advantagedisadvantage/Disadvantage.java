package chapter23reflection.advantagedisadvantage;

/*
    1.反射的有带你：可以动态地创建和使用对象(也是框架底层核心),使用灵活，没有反射机制，
    框架奇数就失去底层支撑
    2.反射的缺点：使用反射基本是解释执行，对执行速度有影响

    3.优化点：Method、Field、Constructor对象都有setAccessible()方法
    其作用时启动和禁用访问安全检查的开关。参数位true时，取消访问检查，可提高反射的效率。
 */

import chapter23reflection.introduction.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Disadvantage {
    public static void main(String[] args) throws Exception {
        //测试反射调用的性能  并对其进行优化

        //传统方式调用testTime()
        test1();//4ms

        //反射方式调用testTime()
        test2();//119ms

        //优化 反射的调用
        test3();//86ms
    }

    public static void test1() {
        Cat cat = new Cat();

        long start1 = System.currentTimeMillis();//返回以毫秒为单位的当前时间。
        for (int i = 0; i < 90000000; i++) {
            cat.testTime();
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }

    public static void test2() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\chapter23reflection\\introduction\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method3").toString();
        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method = cls.getMethod(methodName);

        long start1 = System.currentTimeMillis();//返回以毫秒为单位的当前时间。
        for (int i = 0; i < 90000000; i++) {
            method.invoke(o);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }

    public static void test3() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\chapter23reflection\\introduction\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method3").toString();
        Class cls = Class.forName(classfullpath);
        Object o = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.setAccessible(true);

        long start1 = System.currentTimeMillis();//返回以毫秒为单位的当前时间。
        for (int i = 0; i < 90000000; i++) {
            method.invoke(o);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);
    }
}
