package chapter7objectorientedprogrammingprimary.Overload;
/*
编写程序 1 ，类Overload01 中定义三个重载方法并调用。方法名为m。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，
相乘并输出结果，输出字符串信息。在主类的main ()方法中分别用参数区别调用三个方法
*/

/*
编写程序 1 ，类Overload02
定义三个重载方法max()，第一个方法，返回两个int值中的最大值，
第二个方法，返回两个double值中的最大值
第三个方法,返回三个double值中的最大值，并分别调用三个方法
*/

public class OverloadExercise {
    public static void main(String[] args) {

        Overload01 aOverload01 = new Overload01();
        aOverload01.m(2);
        aOverload01.m(1, 2);
        aOverload01.m("是笨蛋");

        Overload02 aOverload02 = new Overload02();
        System.out.println(aOverload02.max(22, 33));
        System.out.println(aOverload02.max(3.5, 4.0));
        System.out.println(aOverload02.max(1.2, 2.3, 3));
    }
}

class Overload01 {

    //接收一个int参数,执行平方运算并输出结果
    public void m(int n) {
        System.out.println(n * n);
    }

    //接收两个int参数,相乘并输出结果
    public void m(int n1, int n2) {
        System.out.println(n1 * n2);
    }

    //接收一个字符串参数,输出字符串信息
    public void m(String s) {
        System.out.println(s);
    }
}

class Overload02 {
    //返回两个int值中的最大值
    public int max(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    //返回两个double值中的最大值
    public double max(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    //返回三个double值中的最大值
    public double max(double n1, double n2, double n3) {
        return (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3;
    }
}
