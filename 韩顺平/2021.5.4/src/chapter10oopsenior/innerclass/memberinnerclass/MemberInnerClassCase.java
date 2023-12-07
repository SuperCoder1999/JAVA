package chapter10oopsenior.innerclass.memberinnerclass;

/*
    一：成员内部类的使用细节
    1. 成员内部类的定义是在外部类的成员位置，不能用static修饰（修饰了的就叫静态内部类了）
    2. 成员内部类可以直接访问外部类的所有成员，包括私有的
    3. 可以添加任意访问修饰符（因为其本质就是成员）
    4. 作用域：
        和外部类的其他成员一样，为整个类体。
    5. 成员内部类访问外部类的成员可以直接访问
    6. 外部类访问成员内部类，需要创建对象，再访问
    7. 外部其他类访问成员内部类，需要创建内部类对象【共有三种创建形式】
    8. 如果外部类和成员内部类的成员重名时，内部类访问的话，默认遵循就近原则。如果
      想访问外部类的成员，则可以使用（外部类名.this.成员）去访问
 */
public class MemberInnerClassCase {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //外部其他类，使用成员内部类的三种方式
        //老韩解读
        // 第一种方式
        // outer08.new Inner08(); 相当于把 new Inner08()当做是outer08成员
        // 这就是一个语法，不要特别的纠结.
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();
        // 第二方式 在外部类中，编写一个方法，可以返回 Inner08对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();
        // 方法三：
        //相当于第一种方式的缩写版本
        Outer08.Inner08 inner08_2 = (new Outer08()).new Inner08();//可以去掉第一个括号

    }
}

class Outer08 { //外部类
    private int n1 = 10;
    public String name = "张三";

    private void hi() {
        System.out.println("hi()方法...");
    }

    //1.注意: 成员内部类，是定义在外部内的成员位置上
    //2.可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    public class Inner08 {//成员内部类
        private double sal = 99.8;
        private int n1 = 66;

        public void say() {
            //可以直接访问外部类的所有成员，包含私有的
            //如果成员内部类的成员和外部类的成员重名，会遵守就近原则.
            //，可以通过  外部类名.this.属性 来访问外部类的成员
            System.out.println("n1 = " + n1 + " name = " + name + " 外部类的n1=" + Outer08.this.n1);
            hi();
        }
    }

    //方法，返回一个Inner08实例
    public Inner08 getInner08Instance() {
        return new Inner08();
    }


    //写方法
    public void t1() {
        //使用成员内部类
        //创建成员内部类的对象，然后使用相关的方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}

