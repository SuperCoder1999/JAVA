package chapter10oopsenior.final_;

/*
    二：细节下篇
    5. 如果一个类已经是final类了，就没必要再将方法修饰成final了
    6. final不能修饰构造器
    7. final和static往往搭配使用，效率更高（底层编译器做了优化处理），不会导致类加载
        当只想用一个变量（常量）时，不会导致类加载，也就避免浪费资源
    8. 包装类（Integer、Double、Float、Boolean等都是final），String也是final类
 */
public class FinalDetail02 {
    public static void main(String[] args) {
        System.out.println(BBB.num);

        //包装类,String 是final类，不能被继承

    }
}

//final 和 static 往往搭配使用，效率更高，不会导致类加载.底层编译器做了优化处理
class BBB {
    public final static int num = 10000;

    static {
        System.out.println("BBB 静态代码块被执行");
    }
}

final class AAA {
    //一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法
    //public final void cry() {}
}
