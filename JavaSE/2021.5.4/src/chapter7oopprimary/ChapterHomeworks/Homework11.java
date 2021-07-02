package chapter7oopprimary.ChapterHomeworks;

/*
    在测试方法中，调用method方法的形式如下：
    System_.out.println(method(method(method(10.0, 20.0), 100);
    上面的代码编译正确，试泄而出method方法的定义形式
 */
public class Homework11 {
    public static void main(String[] args) {
        Method aMethod = new Method();
        System.out.println(aMethod.method(aMethod.method(10.0, 20.0), 100));
    }
}

class Method {
    /*
        解题过程
        1.首先知道，method两个形参都是double，所以：public ? method(double x1, double x2);
        2.又因为method返回值又作为method的第一个参数，所以返回类型就是double
     */
    public double method(double x1, double x2) {
        return x1+x2;
    }
}
