package chapter8oopintermediate.extend;

public class Detail {
    /*
        术语：父类、基类、超类  子类、派生类
        1. 继承的概念：
            继承可以解决代码复用，让我们的编程更加接近人类思维。当多个类存在相同的
            属性和方法时，可以从这些类中抽象出父类，在父类中定义这些相同的属性和方法，
            所有的子类不需要重新定义这些属性和方法，只需要通过extends来声明继承父类
            即可。

        2. 基本语法
            class 子类名 extends 父类名 {
                特有属性
                特有方法
            }

        3. 注意点：
        1）子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问，但是私有属性
        和方法不能在子类直接访问，要通过父类提供公共的方法去访问
        2)子类必须调用父类的构造器，完成父类的初始化：
            当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器。
            如果父类没有提供无参构造器，则必须在子类的构造器中用 super 指定使用父类的哪个构造器
            来完成对父类的初始化工作，否则编译不通过
        3)如果希望指定地去调用父类地某个构造器，则显式地调用一下
        4）super 必须放在构造器的第一行，且只能用在构造器中
        5）super() 和 this() 都只能放在构造器第一行，所以这两个方法不能共存在同一个构造器中
        6）Java所有类都是Object类的子类，Object是所有类的基类
        7）父类构造器的调用不限于直接父类，将一直往上追溯知道Object类（顶级父类）
        8）子类最多稚嫩继承一个父类（指直接继承），即java中的”单继承“机制。
            如果想让 A类继承B类和C类：A继承B，B再继承C（接口好像也可以）
        9）不能滥用继承，子类和父类之间必须满足 is-a 的逻辑(如果儿子继承父亲也可以说通)
            如： Cat is Animal .

     */

    public static void main(String[] args) {

        //1）子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问，但是私有属性
        //        和方法不能在子类直接访问，要通过父类提供公共的方法去访问
        D3Son son = new D3Son();
        son.Test();
        D3Son son1 = new D3Son(1, 2);
        D3Son son2 = new D3Son(1, 2, 3);
    }
}

class D7Grandpa {
    public D7Grandpa() {
        System.out.println("基类构造器 public D7Grandpa() 被调用");
    }
}

class D3Father extends D7Grandpa {

    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    // 父类构造器
    public D3Father() {
        // super(); // 默认引用父类构造器
        System.out.println("父类无参构造器 public D3Father() 被调用");
    }

    public D3Father(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        System.out.println("父类自定义构造器 public D3Father(int n1, int n2) 被调用");
    }

    public void m1() {
        System.out.println("public void m1()");
    }

    protected void m2() {
        System.out.println("protected void m2()");
    }

    void m3() {
        System.out.println("void m3()");
    }

    private void m4() {
        System.out.println("private void m4()");
    }

    public int getN4() {
        return n4;
    }

    public void callM4() {
        m4();
    }

}

// 光标放在类名上，Ctrl + H ，看类的继承关系
class D3Son extends D3Father {

    // 子类构造器
    public D3Son() {
        // super();// 默认调用父类的无参构造器
        System.out.println("子类的无参构造器 public D3Son() 被调用");
    }

    public D3Son(int n1, int n2) {
        // super();// 默认调用父类的无参构造器
        System.out.println("子类的无参构造器 public D3Son() 被调用");
    }

    // 3)如果希望指定地去调用父类地某个构造器，则显式地调用一下
    public D3Son(int n1, int n2, int n3) {
        //1. 调用父类的无参构造器：什么都不写（由系统调用），或者如下显式调用
        // super();
        //2. 如果调用父类的 public D3Father(int n1, int n2)构造器：
        super(n1, n2);
        //this(); //这两个方法不能共存在同一个构造器中
        System.out.println("子类的无参构造器 public D3Son() 被调用");
    }

    public void Test() {

        System.out.println(n1 + " " + n2 + " " + n3 + " n4无法调用");
        System.out.println("通过public int getN4()获取n4" + getN4() + "\n");

        m1();
        m2();
        m3();
        System.out.println("m4();//'m4()' has private access " +
                "in 'chapter8oopintermediate.extend.D3Father'");
        System.out.println("通过public void callM4()调用m4:");
        callM4();
    }
}