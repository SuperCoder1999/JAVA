package queue;

public class Test {
    public static void main(String[] args) {
        System.out.println(123);
        throw new RuntimeException("错误");
        //System.out.println("继续执行");
    }

    // 测试throw 会不会终止程序
    // - 答案：在编译器中就报错了。
}
