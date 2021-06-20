package chapter10oopsenior.static_.staticparameter;

/*
    一：什么是类变量
    类变量也叫静态变量/静态属性，是该类所有对象共享的变量。任一个该类的对象去访问时
    取到的都是相同的值，任何一个该类的对象修改它时，修改的也是同一个变量

    二：如何定义类变量
    访问修饰符 static 数据类型 变量名;【推荐】
    static 访问修饰符  数据类型 变量名;

    三：如何访问类变量【静态变量的访问修饰符和普通变量的访问权限和范围一致】
    类名.类变量名【推荐】
    对象名.类变量名

    静态变量在同类中的static方法中调用不能有this\super 如果需要和局部变量区别开来：
       只能用  类名.类变量名 的方式
 */
public class StaticCase {

    public static void main(String[] args) {

        //类名.类变量名
        System.out.println(A.name);
            //说明：类变量是随着类的加载而创建，所以即使没有创建对象实例也可以访问
        A a = new A();
        //通过对象名.类变量名
        System.out.println("a.name=" + a.name);

    }
}

class A {
    //类变量
    //类变量的访问，必须遵守 相关的访问权限.
    public static String name = "韩顺平教育";
    //普通属性也就是：普通成员变量/非静态属性/非静态成员变量/实例变量
    private int num = 10;

}
