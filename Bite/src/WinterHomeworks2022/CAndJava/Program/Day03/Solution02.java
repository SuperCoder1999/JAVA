package WinterHomeworks2022.CAndJava.Program.Day03;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/8 21:11
 * Description
 * 1.问题: 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子
 * 都不死，问第n个月的兔子对数为多少？
 * 2.
 */
public class Solution02 {
    public static void main(String[] args) {
        int month = 10;
        int depth = month;
        long[] fibonacciSeries = new long[depth];
        for (int i = 0; i < depth; i++) {
            if (i < 2) {
                fibonacciSeries[i] = 1;
            } else {
                fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
            }
        }
        System.out.println("第第n个月的兔子对数为: " + fibonacciSeries[depth - 1]);
    }
}
