package chapter12exception.homeworks;
import java.util.Scanner;
/*
    1. 编写应用程序EcmDef.java，接收命令行的两个参数(整数)，计算两数相除。
        计算两个数相除，要求使用方法 cal(int n1, int n2)
        对数据格式不正确(NumberFormatException)、
        缺少命令行参数(ArrayIndexOutOfBoundsException)、除0 进行异常处理(ArithmeticException)。
    2. 输入数据是在args中输入的
 */
public class Homework01 {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            if (args.length != 2)
                throw new ArrayIndexOutOfBoundsException("参数数量不对");


            n1 = Integer.parseInt(args[0]);
            n2 = Integer.parseInt(args[1]);

            System.out.println(cal(n1, n2));
        } catch (NumberFormatException e1) {
            System.out.println("参数格式" + e1.getMessage());
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println("参数个数" + e2.getMessage());
        } catch (ArithmeticException e3) {// 这个判断除数为0的处理异常方式也可以在cal方法中处理
            System.out.println("除法" + e3.getMessage());
        }

    }

    public static double cal(int n1, int n2) /*这是默认加的throws ArithmeticException */{
        return n1 / n2;
    }
}

