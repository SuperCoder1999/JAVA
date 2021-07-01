package chapter13commonclass.wrappertype;

/*
    一：包装类和基本数据类型的转换（以int和Integer演示）
    1）jdk5之前的手动装箱和拆箱方式，装箱即：基本类型->包装类型；反之，拆箱
    2）jdk5之后（含jdk5）可自动装箱和拆箱
    3）自动装箱和拆箱底层调用的以掩饰valueOF方法，比如Integer.valueOF()
 */
public class Integer01 {
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
    }
}
