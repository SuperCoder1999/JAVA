package chapter10oopsenior.innerclass.staticinnerclass;
/*
    一：静态内部类的使用：
    说明：静态内部类是定义在外部类的成员位置，并且带有static修饰
    1. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    2. 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    3. 作用域 ：同其他的成员，为整个类体
    4. 静态内部类可以直接访问外部类的静态成员
    5. 外部类访问静态内部类，需要创建对象再访问
    6. 其他类访问静态内部类，需要创建对象再访问（有两种方式，较特殊）
    7. 如果外部类和静态内部类的成员重名，静态内部类访问该重名成员遵循就近原则。
    如果想访问外部类的成员，则可以使用（外部类.成员）去访问
 */
public class StaticInnerClassCase {

    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        //外部其他类 使用静态内部类
        //方式1
        //因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
        //new Outer10().new Inner10();是错误的
        //outer10.new Inner10();也是错误的
        // 不同于成员内部类。这里内部类是静态的。注意static修饰类的情况也只有此时，
        //  所以创建对象时是很特殊的
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        //方式2
        //编写一个方法，可以返回静态内部类的对象实例.
        Outer10.Inner10 inner101 = outer10.getInner10();
        System.out.println("============");
        inner101.say();

        Outer10.Inner10 inner10_ = Outer10.getInner10_();
        System.out.println("************");
        inner10_.say();
    }
}

class Outer10 { //外部类
    private int n1 = 10;
    private static String name = "张三";

    private static void cry() {
    }

    //Inner10就是静态内部类
    //1. 放在外部类的成员位置
    //2. 使用static 修饰
    //3. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    //4. 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    //5. 作用域 ：同其他的成员，为整个类体
    static class Inner10 {
        private static String name = "韩顺平教育";

        public void say() {
            //如果外部类和静态内部类的成员重名时，静态内部类访问的时，
            //默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.成员）
            System.out.println(name + " 外部类name= " + Outer10.name);
            cry();
        }
    }

    public void m1() { //外部类---访问------>静态内部类 访问方式：创建对象，再访问
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10() {
        return new Inner10();
    }

    public static Inner10 getInner10_() {
        return new Inner10();
    }
}