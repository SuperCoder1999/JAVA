package chapter12exception.introduce.commonexception;

/*
    当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当的格式，抛出该异常。
 */

public class NumberFormatException {
    public static void main(String[] args) {
        String name = "韩顺平教育";
        //将String 转成 int
        int num = Integer.parseInt(name);//抛出NumberFormatException
        System.out.println(num);//1234
    }
}
