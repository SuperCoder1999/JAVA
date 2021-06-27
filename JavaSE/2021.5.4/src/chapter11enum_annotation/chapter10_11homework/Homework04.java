package chapter11enum_annotation.chapter10_11homework;
/*
    1.计算器接口具有work方法，功能是运算，有一个手机类Cellphone，
       定义方法testWork测试计算功能，调用计算接口的work方法，
    2.要求调用CellPhone对象 的testWork方法，使用上 匿名内部类

 */
public class Homework04 {
    public static void main(String[] args) {
        testWork(new Calc() {
            @Override
            public double work(double x1, double x2) {
                return x1 + x2;
            }
        }, 10, 20);

        testWork(new Calc() {
            @Override
            public double work(double x1, double x2) {
                return x1 * x2;
            }
        }, 10, 20);
    }
    public static void testWork(Calc calc, double x1, double x2) {
        System.out.println(calc.work(x1, x2));
    }
}

interface Calc {
    public double work(double x1, double x2);
}
/*


    public static void main(String[] args) {
        System.out.println(Homework04.testWork(new Calc(){// 匿名内部类是没有构造器的
            @Override
            public double work(double x1,double x2) {
                return x1 + x2;
            }
        }));
    }

    public static double testWork(Calc calc) {
        return calc.work(1, 2);// 这里不能赋值（没有和外界产生联系）
    }
}

interface Calc {
    public double work(double x1,double x2);
}
 */