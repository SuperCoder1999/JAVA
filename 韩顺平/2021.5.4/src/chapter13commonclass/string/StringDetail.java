package chapter13commonclass.string;

/*
    一：细节
    1. String是一个final类，代表不可变的字符序列
    2. 字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的。

    3. String c1 = "ab" + "cd";常量相加，看的是池。
        String c2 = a + b; 变量相加，是在堆中

    拓展：StringBuilder sb = new StringBuilder(); sb.append(a);
     sb.append(b); sb是在堆中，并且append是在原来字符串的基础上追加的。
 */

public class StringDetail {
    public static void main(String[] args) {

        //Exercise01
        String s1 = "hello";
        s1 = "haha";
        //共创建了2个对象：hello，haha 在常量池中

        //Exercise02
        String a = "hello" + "abc";
        //创建了一个对象
        //分析：
        //编译器做了优化，判断创建的常量池对象是否有引用指向，没有则不创建
        //String a = "hello" + "abc"; -> String a = "helloabc";

        //Exercise03
        String a2 = "hello"; //创建 a对象
        String b = "abc";//创建 b对象
        //解读
        //1. 先 创建一个 StringBuilder sb = StringBuilder()
        //2. 执行  sb.append("hello");
        //3. sb.append("abc");
        //4. String c= sb.toString()
        //最后其实是 c 指向堆中的对象(String) value[] -> 池中 "helloabc"
        String c = a2 + b;
        String d = "helloabc";
        System.out.println(c == d);
        //真还是假? 是false,c指向的是value，而value指向和d一样的常量池地址
        String e = "hello" + "abc";//直接看池， e指向常量池
        System.out.println(d == e);//真还是假? 是true

        //Exercise04
        String s3 = "hspedu";  //s1 指向池中的 “hspedu”
        String s2 = "java"; // s2 指向池中的 “java”
        String s5 = "hspedujava"; //s5 指向池中的 “hspedujava”
        String s6 = (s3 + s2).intern();//s6 指向池中的   “hspedujava”
        System.out.println(s5 == s6); //T
        System.out.println(s5.equals(s6));//T

        //Exercise05

        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}
class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";// 改变的是局部变量的值(所指向的地址值)
        ch[0] = 'h';
    }
}


