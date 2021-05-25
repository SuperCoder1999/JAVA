package chapter7_ObjectOrientedProgramming.VariableScope;

/*
1.变量主要是 属性（也叫成员变量，它是全局变量） 和 局部变量
2. 局部变量 指成员方法中定义的变量 和 代码块中定义的变量
3. 作用域：
    1） 全局变量的作用域：整个 类中
    2） 局部变量的作用域：定义它的代码块中
4. 全局变量定义时会自动赋值，就可以直接使用；局部变量定义后必须赋值才能使用。
 */
public class Introduction {
    public static void main(String[] args) {
    }
}

class Cat {
    int age = 2;// 属性/成员变量/全局变量
    int init;// 对比Sleep方法中的局部变量time
    // int n = 10;//在 eat方法中调用n，会自动找到n。好像后面还有一个this的关键字能在此用到
    String name = "jack";

    // 局部变量 指成员方法中定义的变量 和 代码块中定义的变量
    public void cry() {
        int n = 10;
        // 忘记了 能否在类和属性中定义相同名称的变量，目前没有报错。应该可以，是c语言不可以
        String name = "tom";// 也是局部变量。引用类型实例化的也是变量
    }

    //知识点 3 局部变量作用域
    public void Eat() {
        System.out.println(age);// 全局变量作用于 整个类
        //System.out.println(n);// 错误，局部变量只能作用于 定义它的代码块中
    }

    //知识点 4 全局变量定义时会自动赋值，就可以直接使用；局部变量定义后必须赋值才能使用。
    public void Sleep() {
        int time;
        //System.out.println(init + time);//time必须初始化才能使用
    }
}
