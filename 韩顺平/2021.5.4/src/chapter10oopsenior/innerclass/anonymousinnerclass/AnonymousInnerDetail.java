package chapter10oopsenior.innerclass.anonymousinnerclass;

/*
    细节：
    1. 抽象内部类运行过程中如果重写就会有动态绑定机制。需要分析清楚
        技巧：在脑海里假想有那么一个内部类。这样就好分析了
        （另外Person p = new Person() 等号右边的类名也需要改变成匿名内部类的隐藏类名）
    2. 调用匿名内部类成员可以通过创建的匿名内部类对象调用
    3. 匿名内部类的本质就是局部变量，所以不能添加访问修饰符
    4. 作用域：仅仅在定义它的方法体或代码块中
    5. 匿名内部类可以直接访问外部类的成员,甚至是private
    6. 外部类不能访问匿名内部类,可以在定义的方法内访问（取决于作用域）
    7. 如果外部类和匿名内部类重名，匿名内部类中访问这个重名成员的话，默认遵循就近原则。
    如果想访问外部类的成员，则可以用（外部类名.this.成员）去访问
        外部类名.this的地址就是指所创建的外部类对象地址，这和外部类对象的地址相同。
       对象名  和  外部类名.this  指向同一地址
    8.匿名内部类访问局部变量,会将局部变量优化成effectively final
    (前提是局部变量只有一次赋值操作,之后没有被修改过值,这个会在编译期就优化)
    9.匿名内部类还不能访问一直变化的局部变量
    10.匿名内部类绝对不能修改局部变量,因为局部变量的生存周期是方法结束,而匿名内部类是对象被回收.所以不能修改.只能声明一个变量去接收该局部变量,然后修改声明的变量

    二：匿名内部类 分析运用的时候最好还是想象成分开的形式，new是new的部分，大括号内的就当是新的类
    可以认为，匿名内部类是正在实例化 的 类的子类、接口的实现类、抽象类的实现类
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
    private final int n1 = 99;
    private static final int n2 = 199;

    public void f1() {
        int local = 10;
        //local = 111;

        for (int i = 0; i < 13; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("局部变量id=" + id);
                //System.out.println("局部变量id=" + i);//i不是final,所以局部内部类不能使用
                System.out.println(local);
            }, "生产者" + i).start();
        }

        //创建一个基于类的匿名内部类
        //不能添加访问修饰符,因为它的地位就是一个局部变量
        //作用域 : 仅仅在定义它的方法或代码块中
        Person p = new Person() {
            private final int n1 = 88;
            private final int n2 = 88;

            @Override
            public void hi() {
                //可以直接访问外部类的所有成员，包含私有的
                //如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
                //默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.this.成员）去访问
                System.out.println("匿名内部类重写了 hi方法 n1=" + n1 +
                        " 外部内的n1=" + Outer05.this.n1 + " 局部变量local=" + local);
                System.out.println(Outer05.n2);
                //Outer05.this 就是调用 f1的 对象
                System.out.println("Outer05.this hashcode=" + Outer05.this);
            }
        };
        p.hi();//动态绑定, 运行类型是 Outer05$1
        p.ok("匿名内部类本身就是在父类基础上变化来的，父类还可以正常使用");

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