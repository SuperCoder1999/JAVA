package chapter10oopsenior.innerclass.anonymousinnerclass;

/*
    细节：
    1. 抽象内部类运行过程中如果重写就会有动态绑定机制。需要分析清楚
        技巧：在脑海里假想有那么一个内部类。这样就好分析了
        （另外Person p = new Person() 等号右边的类名也需要改变成匿名内部类的隐藏类名）
    2. 调用匿名内部类成员可以直接调用  、 创建对象后调用
    3. 匿名内部类的本质就是局部变量，所以不能添加访问修饰符
    4. 作用域：仅仅在定义它的方法体或代码块中
    5. 匿名内部类可以直接访问外部类的成员
    6. 外部类不能访问匿名内部类（取决于作用域）
    7. 如果外部类和匿名内部类重名，匿名内部类中访问这个重名成员的话，默认遵循就近原则。
    如果想访问外部类的成员，则可以用（外部类名.this.成员）去访问
        外部类名.this的地址就是指所创建的外部类对象地址，这和外部类对象的地址相同。
       对象名  和  外部类名.this  指向同一地址

    二：匿名内部类 分析运用的时候最好还是想象成分开的形式，new是new的部分，大括号内的就当是新的类
 */
public class AnonymousInnerDetail {
    public static void main(String[] args) {

        Outer05 outer05 = new Outer05();
        outer05.f1();
        //外部其他类---不能访问----->匿名内部类
        System.out.println("main outer05 hashcode=" + outer05);
    }
}

class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符,因为它的地位就是一个局部变量
        //作用域 : 仅仅在定义它的方法或代码块中
        Person p = new Person() {
            private int n1 = 88;

            @Override
            public void hi() {
                //可以直接访问外部类的所有成员，包含私有的
                //如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
                //默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.this.成员）去访问
                System.out.println("匿名内部类重写了 hi方法 n1=" + n1 +
                        " 外部内的n1=" + Outer05.this.n1);
                //Outer05.this 就是调用 f1的 对象
                System.out.println("Outer05.this hashcode=" + Outer05.this);
            }
        };
        p.hi();//动态绑定, 运行类型是 Outer05$1

        //也可以直接调用, 匿名内部类本身也是返回对象
        // class 匿名内部类 extends Person {}
//        new Person(){
//            @Override
//            public void hi() {
//                System_.out.println("匿名内部类重写了 hi方法,哈哈...");
//            }
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//            }
//        }.ok("jack");


    }
}

class Person {//类

    public void hi() {
        System.out.println("Person hi()");
    }

    public void ok(String str) {
        System.out.println("Person ok() " + str);
    }
}
//抽象类/接口...