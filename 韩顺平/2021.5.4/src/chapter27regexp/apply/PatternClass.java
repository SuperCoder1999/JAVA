package chapter27regexp.apply;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java.util.regex 主要三个类之一 Pattern
 */
public class PatternClass {

    public static void main(String[] args) {

    }

    //方法一 直接使用Pattern的matches静态方法
    public static void useRegex1(){
        String content = "I am itnanls，I'm from ydlclass.";
        String pattern = ".*itnanls.*";

        //直接使用Pattern的matches静态方法
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'itnanls' 子字符串? " + isMatch);//true
    }

    //方法二 通过Pattern创建一个Matcher对象 （Matcher对象的方法更丰富）
    public static void useRegex2(){
        String context = "i am itnanls,i com from ydl.";
        String regex = ".*itlils.*";
        //通过String编译出一个Pattern类
        Pattern pattern = Pattern.compile(regex);//源码晦涩难懂
        //通过Pattern创建一个Matcher对象
        Matcher matcher = pattern.matcher(context);
        //Matcher类中的matches()方法
        boolean isMatch = matcher.matches();
        System.out.println(isMatch);//true
    }
}
