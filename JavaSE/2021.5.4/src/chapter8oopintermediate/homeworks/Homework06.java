package chapter8oopintermediate.homeworks;

public class Homework06 {
    /*
        this可以访问本类、父类的非私有成员（默认修饰符必须是同一个包）
        super只能访问父类非私有成员素（默认修饰符必须是同一个包）
     */
    public static void main(String[] args) {
        new Father().test1();
        new Son().test();
    }
}
class Grand {
    String name = "AA";
    private int age = 100;
    public void g1() {
        System.out.println("grand的g1");
    };
}

class Father extends Grand {
    String id = "001";
    private double score;
    public void f1() {};
    public void test1() {
        //super可以访问那些成员
        System.out.println(super.name);
        super.g1();

        //this可以访问那些成员
        System.out.println(this.id);
        this.f1();
        System.out.println(this.name);
        this.g1();
    }
}

class Son extends Father {
    String name = "BB";
    public void g1() {};
    private void show() { }

    public void test() {
        //super可以访问那些成员
        System.out.println(super.name);
        super.g1();
        System.out.println(super.id);
        super.f1();

        // this 可以访问哪些成员
        System.out.println(this.name);//this找到子类就不找了。super正常使用，不影响
        System.out.println("super的 " + super.name);
        this.show();
        this.g1();
        super.g1();
        System.out.println(this.id);
        this.f1();
    }
}