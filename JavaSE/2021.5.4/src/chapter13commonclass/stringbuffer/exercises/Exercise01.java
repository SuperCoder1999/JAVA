package chapter13commonclass.stringbuffer.exercises;

/*
    不清楚的地方，需要看源码
 */

public class Exercise01 {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);//OK
        //需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());//4

        System.out.println(sb);//null
        //下面的构造器，会抛出NullpointerException
        StringBuffer sb1 = new StringBuffer(str);//报错
        //看底层源码 super(str.length() + 16);
        System.out.println(sb1);

    }
}