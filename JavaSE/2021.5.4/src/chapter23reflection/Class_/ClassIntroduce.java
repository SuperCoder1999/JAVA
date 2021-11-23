package chapter23reflection.Class_;

import chapter23reflection.introduction.Cat;

public class ClassIntroduce {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
        //1. Class也是类，因此也继承Object类
        //Class

        //2. Class类对象不是new出来的，而是系统创建的
        //(1) 传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();
        //(2) 反射方式, 刚才老师没有debug到 ClassLoader类的 loadClass, 原因是，我没有注销Cat cat = new Cat();
        /*
            ClassLoader类, 仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("chapter23reflection.introduction.Cat");


        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
        Class cls2 = Class.forName("chapter23reflection.introduction.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());//这两个Class对象是同一个
        Class cls3 = Class.forName("chapter23reflection.introduction.Dog");
        System.out.println(cls3.hashCode());//这个Class对象和前两个就不同了

        //4.每个类的实例都会记住自己是由哪个Class对象所实例化的
        Cat cat = new Cat();
        Class cls = cat.getClass();
        System.out.println(cls);

        //5.通过Class对象调用Class类的方法可以完整地得到一个类地完整结构，通过一系列API即可
        //如之前 cls.getMethod() 等

        //6.Class对象是存放在堆中的(6.7两点都不清楚。关于类加载还是不清楚)
        //7.类的字节码二进制数据是放在方法区的，有的地方称为类的元数据（包括 方法代码、变量名、方法名、
        // 访问权限等） https://www.zhihu.com/question/38496907


    }
}
