package homeworks.class4;
/*
作业标题
递归求斐波那契数列的第 N 项

作业内容
递归求斐波那契数列的第 N 项
 */
public class RecursionFibonacci {
    public static void main(String[] args) {
        System.out.println("第10项fibonacci = " + fibonacci(10));
    }

    public static int fibonacci(int n) {
        if (n <= 2)
            return 1;
        else
            return fibonacci(n -1) + fibonacci(n - 2);
    }
}
