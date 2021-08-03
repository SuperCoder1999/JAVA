package chapter7oopprimary.This;

public class ThisDetail {
    public static void main(String[] args) {
        // this的细节：
        // 1.访问成员方法的语法：this.方法名(参数列表);
        // 2.访问构造器语法：this(参数列表)[没有方法名,因为构造器的方法名就是类名];注意只能在构造器中使用，必须放置在第一条语句
        // 3.this不能在类定义的外部使用，只能在类定义的代码块中(一般使用的范围也就是方法中)使用
        // 4.this用于区分当前类的属性和局部变量
        // 5. 由于this表示的是类的对象，因此在静态成员变量或方法就无法使用"this.数据域"的形式。
        // // 6. 在一个类的方法中调用类成员，尽量不要都用this，因为一旦后期这个方法更改为static，就要手动去掉其中的this

        // 1.访问成员方法的语法：this.方法名(参数列表);
        D1 aD1 = new D1();
        aD1.f3();

        //2.访问构造器语法：
        D2 aD2 = new D2();

        // 3.this不能在类定义的外部使用，只能在类定义的代码块中
        D3 aD3 = new D3();
        //this.age;//this没有代替的对象
        aD3.print();

        // 4.this用于区分当前类的属性和局部变量
        D4 aD4 = new D4();
        aD4.print();
    }
}

class D1 {

    String name;
    int age;

    // 1.访问成员方法的语法：this.方法名(参数列表);
    public void f1() {
        System.out.println("this.方法名(参数列表)调用方法f1");
    }

    public void f2() {
        System.out.println("在类中直接调用:  f2(); ");
    }

    public void f3() {
        System.out.println("调用同类的其他函数");
        this.f1();//当学到继承，就知道为什么要用this调用方法
        f2();
    }
}

class D2 {

    String name;
    int age;

    public D2(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("public D2(String name, int age)构造器被调用");
    }

    public D2() {
        this("Jack",12);// 没有方法名，且必须在第一句（放在第一句和继承有关）
        System.out.println("this(参数列表)调用其他构造器");
    }

}

class D3 {

    String name;
    int age;

    // 3.this不能在类定义的外部使用，只能在类定义的代码块中使用
    public void print() {
        System.out.println("this只能在类定义的代码块中使用(一般使用的范围也就是方法中)" + this.age);
    }

}

class D4 {

    String name = "Jack";

    public void print() {
        String name = "tom";
        System.out.println("name: " + name);
        System.out.println("this.name: " + this.name);
    }
}

// 细节5
class Person {
    private byte age;
    private String sex;
    private String name;
    private static String nation="I am from China";
    
    public static void getNation(){
        //错误使用
        //System.out.println(this.nation);
        System.out.print(nation);
    }
}