package chapter8oopintermediate.extend;

public class Super {
    public static void main(String[] args) {
        /*
            1. 定义：super代表父类的引用，用于访问父类的属性、方法、构造器
            2. 基本语法：
                1）访问父类的属性，但是不能访问父类的private属性  super.属性名
                2）访问父类的方法，但不能访问父类的private方法   super.方法名(参数列表)
                    按照封装的思想：在父类中的一个public方法中调用m3再调用这个public方法
                3）访问父类的构造器：super(参数列表)，只能放在构造器的第一句
         */
        // 1）访问父类的属性，但是不能访问父类的private属性  super.属性名
        S s = new S();
        s.test01();
        s.test02();
    }
}

class F {
    protected String name = "父类";
    int age = 50;
    private int n1 = 22;

    public void m1() {
        System.out.println("父类public方法");
    }

    protected void m2() {
        System.out.println("父类protected方法");
    }

    private void m3() {
        System.out.println("父类private方法");
    }
}

class S extends F {
    String name = "儿子";
    int age = 10;

    public void test01() {
        System.out.println("super调用父类非private属性：" + super.name +"  " + super.age +
                " 想要调用n1还是可以用get方法");
    }

    //2）访问父类的方法，但不能访问父类的private方法   super.方法名(参数列表)
    public void test02() {
        super.m1();
        super.m2();
        //super.m3();
        System.out.println("super.m3()不能调用，按照封装的思想：在父类中的一个public方法" +
                "中调用m3再调用这个public方法");
    }
}