package chapter8oopintermediate.poly.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);//20 属性看编译类型
        s.display();// 20 重写后优先找子类中的display方法
        Base b = s;// 向上转型
        System.out.println(b == s);// true 比较的是地址。空间地址都一样
        System.out.println(b.count);// 10 属性看编译类型
        b.display(); //20 方法的执行看运行类型

        System.out.println("============");

        Sub2 s2 = new Sub2();
        System.out.println(s2.count);//20 属性看编译类型
        s2.display();// 10 重写后优先找子类中的display方法，子类没有找父类
        Base b2 = s2;// 向上转型
        System.out.println(b2 == s2);// true 比较的是地址。空间地址都一样
        System.out.println(b2.count);// 10 属性看编译类型
        b2.display(); //10 方法的执行看运行类型
    }
}

class Base {//父类
    int count = 10;

    public void display() {
        System.out.println(this.count);//这里this还是指代方法所在类对象
    }
}

class Sub extends Base {//子类
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub2 extends Base {//子类
    int count = 20;

    //这里和上面对比
//    public void display() {
//        System.out.println(this.count);
//    }
}


