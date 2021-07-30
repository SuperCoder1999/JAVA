package Classroom.class4function;

/*
    1. 什么是方法：将重复功能的代码抽象出来，避免重复造轮子。

    2. 每次调用方法都会开辟存放方法的栈帧。方法结束就会销毁栈帧。
    所以，除非是static修饰的静态属性，其他的数据每次方法调用都会重新刷新值

    3. 在Java中栈上的地址取不出来。对于int 方法传参的引用。可以使用int[] arr
    或者，运用成员属性，传成员属性，本质是传

    4. 辗转相除法 不需要判断 大小

    5. 方法的重载不是必须在一个类中（继承的也可以实现重载）
 */

public class Knowledge {
    public static void main(String[] args) {
        isPow2();
    }
    public static void isPow2() {
    /*
        判断一个数字是否是 2 的 n 次方
        这里运用二进制的关系 来 判断是否是 2 的次方
        原理：2的次方有特点，即二进制表示法中只有 1 个 1。
        因此，当 - 1 后原本 1后面的0 全变成了 1。此时进行 &。只能得到 0
     */
        for (int i = 0; i < 30; i++) {
            if ((i & (i - 1)) == 0)
                System.out.println(i);
        }
    }
}

// 第5点
class A {
    public int f1(int n1, int n2) {
        return 1;
    }
}
class b extends A {

    //@Override 不是重写。而是重载
    public int f1(int n1, int n2,double n3) {
        return 2;
    }
}