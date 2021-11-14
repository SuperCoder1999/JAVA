package chapter10oopsenior.innerclass.anonymousinnerclass;
/*
    一：匿名内部类定义
     匿名内部类时定义在外部类的局部位置，如方法体中，并且没有类名

    二：基本语法
    new 抽象类或普通类或接口(参数列表) {
        类体
    };

    三：匿名内部类的本质：
    1）本质是类
    2）是内部类
    3）该类没有名字（系统自定义的类名 外部类名$N【n从一开始排序】）
    4）同时还是一个对象

    四：方便记忆的特征
    1. 匿名内部类就是在创建对象的基础上添加了一对 大括号 （基于接口的匿名内部类无法去掉大括号）

        //基于接口的匿名内部类
        //解读
        //1.需求： 想使用IA接口,并创建对象
        //2.传统方式，是写一个类，实现该接口，并创建对象
        //3.需求是 Tiger/Dog 类只是使用一次，后面再不使用
        //4. 可以使用匿名内部类来简化开发
        //5. tiger的编译类型 ? IA
        //6. tiger的运行类型 ? 就是匿名内部类  Outer04$1

            我们看底层 会分配 类名 Outer04$1
            class Outer04$1 implements IA {
                @Override
                public void cry() {
                    System_.out.println("老虎叫唤...");
                }
            }

//7. jdk底层在创建匿名内部类 Outer04$1,立即马上就创建了 Outer04$1实例，并且把地址
//   返回给 tiger
//8. 匿名内部类使用一次，就不能再使用，而创建出来的对象还可以引用。
//  （就是说把工具销毁了，但是作品还留着）
 */

public class AnonymousInnerClassIntroduce {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 { //外部类
    private int n1 = 10;//属性

    public void method() {//方法
        //基于接口的匿名内部类
        //解读
        //1.需求： 想使用IA接口,并创建对象
        //2.传统方式，是写一个类，实现该接口，并创建对象
        //3.需求是 Tiger/Dog 类只是使用一次，后面再不使用
        //4. 可以使用匿名内部类来简化开发
        //5. tiger的编译类型 ? IA
        //6. tiger的运行类型 ? 就是匿名内部类  Outer04$1
        /*
            我们看底层 会分配 类名 Outer04$1
            class Outer04$1 implements IA {
                @Override
                public void cry() {
                    System_.out.println("老虎叫唤...");
                }
            }
         */
        //7. jdk底层在创建匿名内部类 Outer04$1,立即马上就创建了 Outer04$1实例，并且把地址
            //   返回给 tiger
        //8. 匿名内部类使用一次，就不能再使用，而创建出来的对象还可以引用。
            //  （就是说把工具销毁了，但是作品还留着）
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        System.out.println("tiger的运行类型=" + tiger.getClass());
        tiger.cry();
        tiger.cry();
        tiger.cry();

//        IA tiger = new Tiger();
//        tiger.cry();

        //演示基于类的匿名内部类
        //分析
        //1. father编译类型 Father
        //2. father运行类型 Outer04$2
        //3. 底层会创建匿名内部类
        /*
            class Outer04$2 extends Father{
                @Override
                public void TestDao() {
                    System_.out.println("匿名内部类重写了test方法");
                }
            }
         */
        //4. 同时也直接返回了 匿名内部类 Outer04$2的对象
        //5. 注意("jack") 参数列表会传递给 （底层内部类所继承的父类的构造器）
        Father father = new Father("jack") {

            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father对象的运行类型=" + father.getClass());//Outer04$2
        father.test();

        //基于抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            void eat() {
                System.out.println("小狗吃骨头...");
            }
        };
        animal.eat();
    }
}

interface IA {//接口

    public void cry();
}
//class Tiger implements IA {
//
//    @Override
//    public void cry() {
//        System_.out.println("老虎叫唤...");
//    }
//}
//class Dog implements  IA{
//    @Override
//    public void cry() {
//        System_.out.println("小狗汪汪...");
//    }
//}

class Father {//类

    public Father(String name) {//构造器
        System.out.println("接收到name=" + name);
    }

    public void test() {//方法
    }
}

abstract class Animal { //抽象类
    abstract void eat();
}
