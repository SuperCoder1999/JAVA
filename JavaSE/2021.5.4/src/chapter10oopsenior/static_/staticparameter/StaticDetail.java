package chapter10oopsenior.static_.staticparameter;

/*
1. 什么时候需要用类变量
    当需要让所有对象共享一个变量时，就可以考虑使用类变量。
      比如：定义学生类，统计所有学生共交的学费。
2. 类变量和实例变量（普通属性）的区别
    类变量是该类所有对象共享的；而实例变量是每个对象独享的
    类变量可以不用创建对象就调用
3. 加上static称为类变量或静态变量，否则称为实例变量/普通变量/非静态变量
4. 类变量可以通过 类名.类变量名 或者 对象名.类变量名 来访问 【注意访问修饰符】
5. 实例变量不能通过 类名.类变量名 方式访问
6. 类变量是在类加载时就初始化了。也就说，没有创建对象，类信息就加载了，就可以使用类变量了
    那么有个问题：类变量的类加载是在什么时候发生的。（这个需要学到JVM）
7. 类变量的生命周期是随着类的加载开始，直到类消亡而销毁。
 */
public class StaticDetail {
    public static void main(String[] args) {
        B b = new B();
        //System.out.println(B.n1);
        System.out.println(B.n2);

        //静态变量是类加载的时候，就创建了,所以我们没有创建对象实例
        //也可以通过类名.类变量名来访问
        System.out.println(C.address);

    }
}

class B {
    public int n1 = 100;
    public static int n2 = 200;
}

class C {
    public static String address = "北京";
}
