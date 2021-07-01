package chapter12exception.homeworks;

/*
    输出结果:
    B   注意 System.out.println("A"); 由于有异常而不会执行
    C
    D
 */
public class Homework03 {
    public static void func() /* 省略了 throws RuntimeException */{//静态方法
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {//main方法
        try {
            func();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println("C");
        }
        System.out.println("D");
    }
}
