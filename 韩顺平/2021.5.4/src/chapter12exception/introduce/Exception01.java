package chapter12exception.introduce;
 /*
    一：基本概念：
            Java语言中，将程序执行中发生的不正常情况称为“异常”。（开发过程中的语法错误和逻辑错误（冒泡排序）不是异常）

            二：执行过程中你发生的异常分为两类
            1. Error（错误）：Java虚拟机无法解决的严重问题。如：JVM几桶内部错误、资源耗尽等严重情况。
            比如：StackOverflowError[栈溢出]和OOM(out 0f memory),Error是严重错误，程序会崩溃

            2.Exception：其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如空指针访问，
            驶入读取不存在的文件，网络链接中断等等。

            Exception分为两大类：运行时异常[程序运行时发生的异常]和编译时异常[编程时编译器检测出的异常]。
            */
public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;//Scanner();

        //解读
        //1. num1 / num2 => 10 / 0
        //2. 当执行到 num1 / num2 因为 num2 = 0, 程序就会出现(抛出)异常 ArithmeticException
        //3. 当抛出异常后，程序就退出，崩溃了 , 下面的代码就不在执行
        //4. 大家想想这样的程序好吗? 不好，不应该出现了一个不算致命的问题，就导致整个系统崩溃
        //5. java 设计者，提供了一个叫 异常处理机制来解决该问题
//        int res = num1 / num2;
        //如果程序员，认为一段代码可能出现异常/问题，可以使用try-catch异常处理机制来解决
        //从而保证程序的健壮性
        //将该代码块->选中->快捷键 ctrl + alt + t -> 选中 trycatch-catch
        //6. 如果进行异常处理，那么即使出现了异常，程序可以继续执行
        //  注意： try_catch 之后的程序继续执行。try内部遇到异常就捕获异常并进入catch内了
        try {
            int res = num1 / num2;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("出现异常的原因=" + e.getMessage());//输出异常信息
        }

        System.out.println("程序继续运行....");
    }
}