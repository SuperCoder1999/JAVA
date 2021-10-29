package chapter23reflection.classload_;

/*
    一：类加载有三个大阶段，其中第二阶段由三个小阶段，共五个阶段
    二：第一大阶段：<加载阶段>：JVM在该阶段的主要目的是将字节码从不同的数据源(可能时class文件、也可能时jar包[引入的类]
    ，甚至网络)转化为 二进制字节流加载到内存种，并生成一个代表该类的java.lang.Class对象
    三：第二大阶段<链接>
    1. 1.1验证阶段：目的是保证Class文件的字节流中包含的信息复合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
       1.2包括：文件格式验证（是否以魔数oxcafebabe开头）、元数据验证、字节码验证和符号引用验证。
       1.3可以考虑使用-Xverify:none 参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间。
    2. 2.1准备阶段：JVM会在该阶段给静态变量，分配内存并初始化（对应数据类型默认初始值，如0,0L,null,false等)。
     这些变量所知用的内存都将在方法区中进行分配。
    3. 解析阶段：虚拟机将常量池内的符号引用转换为直接引用的过程。（暂时不清楚原理）
    四：初始化：4.1到初始化阶段，才真正开始执行类中定义的Java程序代码，此阶段是执行<clinit>()方法的过程。
    4.2<clinit>()方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有静态变量的赋值动作和静态代码块
    中的语句，并进行合并。
    4.3虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，
    那么只会有一个线程去执行这个类地<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕。
 */

public class FiveStepsInClassLoad {
    public static void main(String[] args) {

    }
}

//链接阶段 的 准备阶段
class A {
    //属性-成员变量-字段
    //分析类加载的链接阶段-准备 属性是如何处理
    //1. n1 是实例属性, 不是静态变量，因此在准备阶段，是不会分配内存
    //2. n2 是静态变量，分配内存 n2 是默认初始化 0 ,而不是20
    //3. n3 是static final 是常量, 他和静态变量不一样, 因为一旦赋值就不变。所以分配内存时就赋值n3 = 30
    public int n1 = 10;
    public static  int n2 = 20;
    public static final  int n3 = 30;
}


//初始化阶段
class C {
    public void test() {
        //分析
        //1. 加载B类，并生成 B的class对象
        //2. 链接准备阶段： num = 0
        //3. 初始化阶段
        //    依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并合并
        /*
                clinit() {
                    System.out.println("B 静态代码块被执行");
                    //num = 300;这句话相当于省略了
                    num = 100;
                }
                合并: num = 100

         */

        //new B();//类加载
        //System.out.println(B.num);//100, 如果直接使用类的静态属性，也会导致类的加载

        //看看加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            //正因为有这个机制，才能保证某个类在内存中, 只有一份Class对象
            synchronized (getClassLoadingLock(name)) {
            //....
            }
            }
         */
        B b = new B();
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B() {//构造器
        System.out.println("B() 构造器被执行");
    }
}