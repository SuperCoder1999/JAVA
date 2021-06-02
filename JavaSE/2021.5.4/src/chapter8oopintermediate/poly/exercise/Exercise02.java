package chapter8oopintermediate.poly.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);//20 看编译类型
        s.display();// 20 重写后优先找子类中的display方法
        Base b = s;// 向上转型
        System.out.println(b == s);// true 比较的是地址。空间地址都一样
        System.out.println(b.count);// 10 看编译类型
        b.display(); //20 看运行类型
    }
}

class Base {//父类
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {//子类
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}



