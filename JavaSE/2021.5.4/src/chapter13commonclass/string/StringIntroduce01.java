package chapter13commonclass.string;

/*
    一：String基本介绍
    1. String对象用于保存字符串，也就是一组字符序列
    2. 字符串常量对象是用双引号括起来的字符序列。
    3. 字符串的字符使用Unicode字符编码，一个字符（无论是汉字或英文）占两个字节。
    4. String类常用构造器（手册中有全部的）
        1)String  s1 = new String();
        2)String  s2 = new String(String original);
        3)String  s3 = new String(char[] a);
        4)String  s4 =  new String(char[] a,int startIndex,int count)
        5)String s5 = new String(byte[] b)
    5. String 实现接口/继承类的意义：
        1）Serializable：说明String可以串行化（即可以在网络上传输）
        2）Comparable：说明String对象可以比较（具体比较规则看源码)
        3）CharSequence:字符序列
    6. String 是final 类，不能被其他的类继承
    7. String 有属性 private final char value[]; 用于存放字符串内容
        一定要注意：value 是一个final类型， 不可以修改(需要功力)：即value不能指向
       新的地址，但是单个字符内容是可以变化
 */

public class StringIntroduce01 {
    public static void main(String[] args) {
        String name = "jack";
        name = "tom";
        /*
            这里为什么name指向发生变化：
          1.name是String对象名，对象名指向的是另一个String字符串。
          name中value数组并没有指向任何字符串，而是内存中自动存储了该字符串
          2.String name = new String("123");
          这里name依旧可以指向其他String实例，原因同上。
          补充一点：这里name中value数组并没有指向任何字符串。
          而new出来的String对象中的value指向了内存中的字符串
         */
        final char[] value = {'a', 'b', 'c'};
        char[] v2 = {'t', 'o', 'm'};
        value[0] = 'H';
        //value = v2; 不可以修改 value地址

    }
}