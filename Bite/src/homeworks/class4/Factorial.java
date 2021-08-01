package homeworks.class4;
/*
作业标题
递归求 N 的阶乘

作业内容
递归求 N 的阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("5的阶乘 = " + factorial(5));
    }

    public static int factorial(int num) {
        if (num <= 1)
            return 1;
        else
            return num * factorial(num - 1);
    }
}
