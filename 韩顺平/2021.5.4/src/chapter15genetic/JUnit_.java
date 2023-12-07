package chapter15genetic;

/*
    一：为什么需要JUnit
    1. 一个类有很多功能代码需要测试，为了测试，就需要写入到main方法中
    2. 如果有多个功能代码测试，就需要来回注销，很麻烦
    3. 如果可以直接运行一个方法，并且可以给出相关信息，就方便多了。

    4. 缺点：因为 有些方法需要其他方法传参进来，这时 单独运行一个方法，无法看出效果

    二：添加方式
    在一个方法前 写下 @Test 后需要alt+enter -> 选择JUnit5.4 -> Ok

    三：注意
    通过源码可以看到 @Test 只能用于注释 方法
    另外，JUnit 的 @Test 函数不能有 返回值，有返回值，控制台就不会输出内容
 */


import org.junit.jupiter.api.Test;

public class JUnit_ {
    public static void main(String[] args) {
        //传统方式，来回注销
        //new JUnit_().m1();
        //new JUnit_().m2();

    }


    @Test // 写下 @Test 后需要alt+enter -> 选择JUnit5.4 -> Ok
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
