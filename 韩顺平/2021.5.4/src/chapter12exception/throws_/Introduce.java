package chapter12exception.throws_;

/*
    一：介绍
    1. 如果一个方法（中的语句执行时）可能生成某种异常，但是并不能确定如果处理这个异常，则此方法应显式地声明抛出异常，
    表示该方法将不对异常进行处理，而由该方法地调用者负责处理。
    2. 在方法声明中用throws语句可以声明抛出异常地列表。throws后面地异常类型可以是方法中产生地异常类型，也可以是它的父类。

    二：throws
    1.Jvm处理异常的方式：1.输出异常信息  2.退出程序 （main函数后面默认含有 throws Exception）

    2.throws是不断向调用该方法的调用者 抛出 异常，目的是想让调用者 来处理该异常（调用者可以try-catch 或 throws来处理）
    3.throws相当于在try-catch的catch中直接throw捕获的异常
 */
public class Introduce {
    public void test() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw e;
        }
    }
}
