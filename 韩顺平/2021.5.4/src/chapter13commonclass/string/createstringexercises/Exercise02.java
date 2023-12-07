package chapter13commonclass.string.createstringexercises;

/*
    intern方法：
    当调用intern方法时，如果常量池中已经包含一个等于此String对象的字符串（用
    equals(Object)方法确定)，则返回常量池中的字符串地址。否则，将此String对象添加到
    常量池中，并返回此String对象的引用。

    简洁点：intern() 方法返回常量池地址
 */
public class Exercise02 {
    public static void main(String[] args) {
        String a = "hsp"; //a 指向 常量池的 “hsp”
        String b = new String("hsp");//b 指向堆中对象
        System.out.println(a.equals(b)); //T
        System.out.println(a == b); //F
        //b.intern() 方法返回常量池地址
        System.out.println(a == b.intern()); //T //intern方法自己先查看API
        System.out.println(b == b.intern()); //F

    }
}