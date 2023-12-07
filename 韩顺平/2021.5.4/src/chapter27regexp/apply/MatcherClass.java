package chapter27regexp.apply;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * java.util.regex 主要三个类之一 Matcher
 */
public class MatcherClass {

    public static void main(String[] args) {
        startAndEnd();
        searchFunc();
        testReplace();
    }

    /**
     * 匹配方法
     */
    public static void startAndEnd() {
        String regex = "cat";
        String content = "cat cat dog dog cat";
        Pattern pattern = Pattern.compile(regex);// 编译String获得Pattern实例
        Matcher m = pattern.matcher(content); // 获取 matcher 对象

        int count = 0;
        //start()、end()不能直接使用。必须要先find()，我的猜测：find()过程中将匹配的索引存到start、end属性中
        while (m.find()) {//从头遍历一次，找到就返回true。下一次接着上次返回的位置继续遍历
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }
    }

    /**
     * 查找方法
     * lookingAt()：返回目标字符串前面部分与 Pattern 是否匹配，和String.startWith()相同
     */
    public static void searchFunc() {
        String regex = "itnanls";
        String content1 = "itnanls";
        String content2 = "itnanls is very handsome  !";
        String content3 = "My name is itnanls.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher(content1);
        Matcher matcher2 = pattern.matcher(content2);
        Matcher matcher3 = pattern.matcher(content3);

        System.out.println("matches1(): " + matcher1.matches());//true
        System.out.println("lookingAt1(): " + matcher1.lookingAt());//true
        System.out.println("matches2(): " + matcher2.matches());//false
        System.out.println("lookingAt2(): " + matcher2.lookingAt());//true
        System.out.println("matches3(): " + matcher3.matches());//false
        System.out.println("lookingAt3(): " + matcher3.lookingAt());//true
    }

    /**
     * 替换方法
     *
     */
    public static void testReplace(){
        String regex = "itnanls";
        String context = "My name is itnanls, itnanls is very handsome. ";
        String replacement = "itlils";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(context);

        String result1 = m.replaceAll(replacement);//My name is itlils, itlils is very handsome.
        System.out.println(result1);
        String result2 = m.replaceFirst(replacement);//My name is itlils, itnanls is very handsome. 
        System.out.println(result2);
    }
}
