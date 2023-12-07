package chapter13commonclass.string;

/*
    一：简介：
    String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低，因此Java还提供了StringBuilder
    和StringBuffer方法来增强String功能，并提高效率。
 */


public class StringMethods01 {
    public static void main(String[] args) {
        //1. equals 前面已经讲过了. 比较内容是否相同，区分大小写
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));//false
        //1.2
        String s = "hello";String t = "hello";
        char c [ ] = {'h','e','l','l','o'};
        //这里使用了equals的重载方法，如果输入一个不是String类型的对象，就会返回false
        System.out.println(t.equals(c));
        //1.3 String的“+”，是否直接复用常量池中的已经拼接好的字符串常量:
            //1. 如果“+”的对象含有String变量，则拼接后产生新的String对象。不是复用常量池
            //2. 如果“+”的对象都是字符串常量。则在编译时就优化为常量池的字符串常量
        String ab = "ab";
        String str_a="a";
        String str_b="b";
        String str_c=str_a+str_b;
        String str_cc="a"+"b";
        String str_ccc=str_a+"b";
        String str_d=new String("ab");
        System.out.println("str_c==ab= " + (str_c==ab));//false
        System.out.println("str_cc==ab= " + (str_cc==ab));//true
        System.out.println("str_ccc==ab= " + (str_ccc==ab));//false
        System.out.println("str_c==str_d= " + (str_c==str_d));//false

        
        // 2.equalsIgnoreCase 忽略大小写的判断内容是否相等
        String username = "johN";
        if ("john".equalsIgnoreCase(username)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }

        // 3.length 获取字符的个数，字符串的长度
        System.out.println("韩顺平".length());

        // 4.indexOf 获取字符/字符串在字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
        String s1 = "wer@terwe@g";
        int index = s1.indexOf('@');
        System.out.println(index);// 3
        System.out.println("weIndex=" + s1.indexOf("we"));//0

        // 5.lastIndexOf 获取字符/字符串在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
        s1 = "wer@terwe@g@";
        index = s1.lastIndexOf('@');
        System.out.println(index);//11
        System.out.println("ter的位置=" + s1.lastIndexOf("ter"));//4

        // 6.substring 截取指定范围的子串
        String name = "hello,张三";
        //下面name.substring(6) 从索引6开始截取后面所有的内容
        System.out.println(name.substring(6));//截取后面的字符
        //name.substring(0,5)表示从索引0开始截取，截取到索引 5-1=4位置 即[0,5)左开右闭区间
        System.out.println(name.substring(2,5));//llo


    }
}
