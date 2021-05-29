package chapter7objectorientedprogrammingprimary.ChapterHomeworks;

/*
     编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
     定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示)
     并创建两个对象，分别测试
 */
public class Homework06 {
    public static void main(String[] args) {
        Cale aCale = new Cale(1, 2);
        aCale.info();
        Cale bCale = new Cale(15, 20);
        bCale.info();
        Cale cCale = new Cale(15, 0);
        cCale.info();
    }
}

class Cale {
    double x1;
    double x2;

    public Cale(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double sum() {
        return x1 + x2;
    }

    public double subtraction() {
        return x1 - x2;
    }

    public double multiplication() {
        return x1 * x2;
    }

    public Double division() {
        if (x2 != 0)
            return x1 / x2;
        else
            return null;
    }

    public void info() {
        if (division() != null)
            System.out.println("sum= " + this.sum() + " subtraction= " +
                    subtraction() + " multiplication= " + this.multiplication()
            + " division= " + division());
        else
            System.out.println("除数不能为零");
    }
}
