package chapter12exception.trycatch.exercises;

/*
    利用异常处理机制来实现 反复输入正确字符
 */
import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        int i;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("输入整数");
            String input = scanner.next();
            try {
                i = Integer.parseInt(input);//这里是可能抛出异常
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("输入格式有误，重输");
            } finally {
                System.out.println("finally");
            }
        }
        System.out.println(i);
    }
}