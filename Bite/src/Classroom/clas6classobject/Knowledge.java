package Classroom.clas6classobject;

/*
    1. 静态成员变量不属于实例对象而属于类
    静态成员变量在方法区中（本地栈、JVM栈、程序计数器、堆、方法区）

    2. 构造器的访问修饰符和普通的方法性质相同

    3. this代表当前对象的引用。前提是：对象完全创建（创建步骤全部执行完毕）
    构造器中的this 是代表 为对象分配的内存。（即对象的前身）
 */

public class Knowledge {
    public static void main(String[] args) {
        //A a = new A();//private 的构造器无法调用
    }


}

class A {
    private A() {
        System.out.println("wode");
    }
}