package question;

/*
    1. System.out.println(object);为什么能输出其他类型的对象？
    答案：根据动态绑定 调用运行类型 的toString()方法
 */

public class Test01 {
    public static void main(String[] args) {
        String str = "123";
        Object o = str;
        System.out.println(o);
        //这里调用o.toString()方法。由于动态绑定，所以进入到String.toString()方法中了。
    }
}
