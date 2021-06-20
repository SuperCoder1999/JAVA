package chapter10oopsenior.static_.staticmethod;
/*
  1. 类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区，有些区别：
    类方法无this的参数
    普通方法中隐含this参数（这就解释了为啥类方法中不允许this、super关键字）
  2. 类方法可以通过类名调用，也可以通过对象名调用
  3. 普通方法和对象有关，需要通过对象名调用，比如对象名.方法名(参数)，不能通过类名调用
  4. 类方法中不允许使用和对象有关的关键字：this\super ，
    普通方法（成员方法）中可以（包括在普通方法中使用类变量也可以使用this\super)
  5. 类方法（静态方法）中 只能 访问静态变量和静态方法 【访问非静态类的成员可以通过创建对象来实现】
  6. 普通成员方法，既可以访问 非静态成员也可以访问静态成员
 */
public class StaticMethodDetail {
    public static void main(String[] args) {

        D.hi();//ok
        //非静态方法，不能通过类名调用
        //D.say();, 错误，需要先创建对象，再调用
        new D().say();//可以
        D.hello();
        new D().ok();
    }
}

class D {

    private int n1 = 100;
    private static int n2 = 200;

    public void say() {//非静态方法,普通方法

    }

    public static void hi() {//静态方法,类方法
        //类方法中不允许使用和对象有关的关键字，
        //比如this和super。普通方法(成员方法)可以。
        //System.out.println(this.n1);
    }

    //类方法(静态方法)中 只能访问 静态变量 或静态方法
    //口诀:静态方法只能访问静态成员.
    public static void hello() {
        //System.out.println(n1);//n1不是静态成员
        System.out.println((n2+=10));
        System.out.println((D.n2+=10));
        //System.out.println(this.n2);不能使用
        hi();//OK
        //say();//错误
        new D().say();//这样就可以实现在类方法中调用非静态类的成员
    }

    //普通成员方法，既可以访问  非静态成员，也可以访问静态成员
    //小结: 非静态方法可以访问 静态成员和非静态成员
    public void ok() {
        //非静态成员
        System.out.println(n1);
        say();
        //静态成员
        System.out.println(n2);
        hello();
        System.out.println(this.n2);

    }
}
