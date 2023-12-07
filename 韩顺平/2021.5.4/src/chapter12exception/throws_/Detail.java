package chapter12exception.throws_;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
    二：throws
    1.Jvm处理异常的方式：1.输出异常信息  2.退出程序 （main函数后面默认含有 throws Exception）

    2.throws是不断向调用该方法的调用者 抛出 异常，目的是想让调用者 来处理该异常（可以try-catch 或 throws来处理）


    细节：
    1. 对于编译异常，程序中必须处理，比如 try-catch 或者 throws
      1）throws抛给调用者之后，调用者必须进行处理try-catch 或者 throws。
     （编译异常地处理必须显式声明处理方式，而运行时异常系统默认添加throws到调用者所以可以不用处理）
      2）throws不等于处理异常，throws向JVM后才不用处理

    2. 对于运行时异常，程序中如果没有处理，默认就是throws地处理方式

    3. 子类重写父类的方法时，对抛出异常的规定:子类重写的方法，
     所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
     (如果子类父类都没有throws，那么在出现异常时就会同时throws Exception)
     4. 在throws 过程中，如果有方法 try-catch , 就相当于处理异常，就可以不必throws
 */

public class Detail {

    public static void main(String[] args) {
        f2();
    }

    public static void f2() /*这里如果出现异常，则默认添加后面这句话 throws ArithmeticException*/ {
        //1.对于编译异常，程序中必须处理，比如 try-catch 或者 throws
        //2.对于运行时异常，程序中如果没有处理，默认就是throws的方式处理

        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }

    public static void f1() throws FileNotFoundException {
        //这里大家思考问题 调用f3() 报错
        //解读
        //1. 因为f3() 方法抛出的是一个编译异常
        //2. 即这时，就要f1() 必须处理这个编译异常
        //3. 在f1() 中，要么 try-catch-finally ,或者继续throws 这个编译异常
        f3(); // 抛出异常
    }

    public static void f3() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }

    public static void f4() {
        //解读:
        //1. 在f4()中调用方法f5() 是OK的
        //2. 原因是f5() 抛出的是运行异常 
        //3. 而java中，并不要求程序员显示处理,因为有默认处理机制
        f5();
    }

    public static void f5() throws ArithmeticException {

    }
}

class Father { //父类
    public void method() throws RuntimeException {
    }
}

class Son extends Father {//子类

    //3. 子类重写父类的方法时，对抛出异常的规定:
    //   子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
    //4. 在throws 过程中，如果有方法 try-catch , 就相当于处理异常，就可以不必throws
    @Override
    public void method() throws ArithmeticException {
    }
}
