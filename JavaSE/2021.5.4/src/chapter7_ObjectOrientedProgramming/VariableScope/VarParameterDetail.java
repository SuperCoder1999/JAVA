package chapter7_ObjectOrientedProgramming.VariableScope;

public class VarParameterDetail {
    public static void main(String[] args) {
        // 1. 属性(全局变量)和局部变量可以重名，访问时遵循就近原则
        // 2. 在同一作用域，如同一方法或同一类中，两个变量不能重名
        // 3. 1）属性生命周期较长，伴随对象的创建而创建，伴随对象的销毁而销毁（销毁指对象没有被任何变量指向。
            // 2）局部变量生命周期短，伴随代码块的执行而创建，伴随代码块的结束而销毁，即一次方法调用的过程
        // 4. 作用域范围不同
            // 1)全局变量/属性：可以被本类（不用创建对象）或其他类使用（通过创建对象调用）
            // 2)局部变量：只能在本类中创建它的方法调用
        // 5. 修饰符不同
            // 1)全局变量/属性可以加修饰符(public protected private 默认)
            // 2）局部变量不可以加修饰符
        //3. 1）属性生命周期较长，伴随对象的创建而创建，伴随对象的销毁而销毁（销毁指对象没有被任何变量指向。
        //   2）局部变量生命周期短，伴随代码块的执行而创建，伴随代码块的结束而销毁，即一次方法调用的过程
        Person aPerson = new Person();
        aPerson.say();//局部变量age 在say被调用时 创建在栈区；方法结束后栈区抹除方法信息（术语有些忘记）
            //而全局变量 n1 仍然可以只用，除非 aPerson指向其他子类，这个类的内存空间就会被回收

        // 4. 作用域范围不同
        // 1)全局变量/属性：可以被本类（不用创建对象）或其他类使用（通过创建对象调用）
        Teacher aTeacher = new Teacher();
        aTeacher.test();
        aTeacher.test02(aPerson);

    }
}

class Person {

    // 1. 属性(全局变量)和局部变量可以重名，访问时遵循就近原则
    public String name = "Jack";
    public void say() {
        int age = 10;
        String name = "king";//和属性同名
        System.out.println("属性（全局变量）和局部变量可以重名，访问时遵循就近原则：" + name);//遵循就近原则
    }

    // 2. 在同一作用域，如同一方法或同一类中，两个变量不能重名
    public int n1 = 0;
    //int n1 = 2;// 不能重复定义变量

}

// 4. 作用域范围不同
// 1)全局变量/属性：可以被本类（不用创建对象）或其他类使用（通过创建对象调用）
class Teacher {// 其实 main 方法中也可以作为示例

    public void test() {
        Person aPerson = new Person();// 只有在方法中才能创建对象
        System.out.println("Teacher类的方法中调用Person中的属性：" + aPerson.n1);
    }

    public void test02(Person p) {
        System.out.println("另一种在其他类中调用该类的属性：" +
                "调用在Teacher类的方法中创建Person形参" + p.n1);
    }

    // 5. 修饰符不同
    // 1)全局变量/属性可以加修饰符(public protected private 默认)
    // 2）局部变量不可以加修饰符
    int n1 = 19;// 属性可以添加修饰符
    public void read() {
        //private int n2 = 20;//不可以加修饰符
    }
}
