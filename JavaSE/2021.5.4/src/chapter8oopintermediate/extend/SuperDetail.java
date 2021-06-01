package chapter8oopintermediate.extend;

/*
    super 和 this 的比较
    1. 访问属性：
        super：访问本类的属性，如果本类没有就从父类中继续查找
        this：直接从父类中开始查找

    2. 调用方法
        super：访问本类中的方法，如果本类中没有就从父类中继续朝朝
        this：直接从父类中开始查找

    3. 调用构造器
        this：调用本类中的构造器，且必须放在构造器的首行
        super：调用父类的构造器，必须放在子类构造器的首行

    4. 特殊点
        this：表示当前对象
        super：子类中访问父类对象
 */
public class SuperDetail {
    public static void main(String[] args) {

        /*
        一：细节
            1）子类和父类的成员（属性或方法）重名时，为了访问父类的成员，必须通过super。如果没有重名
                    ，使用super、this直接访问效果一样
            2)如果多个基类中都有同名的成员，使用super访问遵循就近原则
            3)super：调用父类的构造器，必须放在子类构造器的首行。但不能像方法那样，寻找到爷爷类
         */

        // 细节 1）
        B b = new B();
        b.test();
    }
}

class Base {
    public Base() {

    }

    public Base(String name) {
        System.out.println("Base类的构造器");
    }
}
class A extends Base {
    public int n1 = 888;
    private int n2 = 999;

    public void m1() {
        System.out.println("A类m1方法");
    }

    private void m2() {
        System.out.println("A类m2方法");
    }

//    public A(String name) {
//        System.out.println("Base类的构造器");
//    }
}

class B extends A {
    public int n1 = 88;
    private int n2 = 99;

    public void m1() {
        System.out.println("B类的m1方法");
    }

    private void m2() {
        System.out.println("B类的m2方法");
    }

    public void test() {
        /*
        调用父类的方法有三种方式：m1() n1 \ this.m1() this.n1 \ super.m1() super.n1
        1. m1() \ this.m1() 的找寻顺序
            1）先找本类，如果有，则调用
            2）如果本类没有，则找父类（如果有，并可以调用，则调用）
            3）如果父类没有，则继续找父类的父类，知道Object类
            4）如果查找的过程中找到了，但是不能访问，就会报错（后续父类中的能访问的成员也不会再寻找）
                想要调用可以使用get方法
            5）如果查找结束还没有找到，会提示成员不存在

        2. super.m1() 、 super.n2()找寻顺序
            1）与m1()\this.m1()先比，没有 1） ，直接从父类开始找 --- 用于应对子类父类成员重名情况

            2）如果多个基类中都有同名的成员，使用super访问遵循就近原则
         */
        m1();
        this.m1();
        super.m1();
        m2();
        this.m2();
        //super.m2();报错

        System.out.println(n1);
        System.out.println(this.n1);
        System.out.println(super.n1);
        System.out.println(n2);
        System.out.println(this.n2);
        //System.out.println(super.n2);报错

    }

    //super：调用父类的构造器，必须放在子类构造器的首行(）
    public B() {
        //super("Jack"); 报错，不能像方法那样，寻找到爷爷类
    }
}