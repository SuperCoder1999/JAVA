package chapter13commonclass.wrappertype;

/*
    一：包装类和基本数据类型的转换（以int和Integer演示）
    1）jdk5之前的手动装箱和拆箱方式，装箱即：基本类型->包装类型；反之，拆箱
    2）jdk5之后（含jdk5）可自动装箱和拆箱
    3）自动装箱和拆箱底层调用的以掩饰valueOF方法，比如Integer.valueOF()

    二：注意
    1. 自动拆装箱的细节:
     1)基本数据类型的装箱只能装箱为对应的包装类.之后不会"自动转换类型"
     比如: Long l = 1000; 编译报错,必须提供long类型的参数,即1000L,因为1000自动装箱为Integer,而Integer无法赋值给Long
     2)拆箱后可以自动转换类型: long l = new Integer(1000);
    2. 包装类是Object的子类，可以用于指向包装类
    装箱过程是通过调用包装器的valueOf方法实现的
    拆箱过程是通过调用包装器的xxxValue方法实现的（xxx表示对应的基本数据类型）
 */
public class Transformation {
    public static void main(String[] args) {
        //演示int <--> Integer 的装箱和拆箱
        //jdk5前是手动装箱和拆箱
        //手动装箱 int->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        //Integer -> int
        int i = integer.intValue();

        //jdk5后，就可以自动装箱和自动拆箱
        int n2 = 200;
        //自动装箱 int->Integer
        Integer integer2 = n2; //底层使用的是 Integer.valueOf(n2)
        Integer integer3 = 100;//也可以
        //自动拆箱 Integer->int
        int n3 = integer2; //底层仍然使用的是 intValue()方法

        //包装类的自动装箱只会将显示的基本数据类型转换到对应包装类
        //Double d = 100;//错误，100转换为Integer，而Integer和Double不是继承关系
        Double d = 100d;//正确

        Object o = 100;//正确：100自动装箱=》Integer=》向上转型Object
    }
}

class Test2
{
    public static void add(Byte b) {
        b++;//这里为什么没有影响到 “引用传值”的类对象b？？？？
    }
    public static void main(String[] args) {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");//-128
        add(b);
        System.out.print(b + "");//127
    }
}

