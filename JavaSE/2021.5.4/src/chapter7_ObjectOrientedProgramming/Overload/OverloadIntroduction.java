package chapter7objectorientedprogrammingprimary.Overload;

public class OverloadIntroduction {
    public static void main(String[] args) {
        // 重载情况：同一个类中，多个方法同名、而形参列表不同
        // 其好处：1. 减少起名的麻烦  2. 有利于 接口 编程
        // 例如：
        System.out.println(100);
        System.out.println("hello world");
        System.out.println('h');
    }
}
