package chapter8oopintermediate.poly;

public class PolyDetail02 {
    public static void main(String[] args) {
        /*
        二：多态的向下转型
        1.语法：子类类型 引用名（对象名） = （子类类型）父类引用 --父类引用指的是使用了向上转型的子类的引用
        2.只能强转父类的引用，不能强转父类的对象
        3.要求父类的引用必须指向的是当前目标类型的对象。准确来说：转换过后的类型必须 是 父类向上转型的 父类或本类
        4.当向下转型后，可以调用子类类型中所有的成员（此时当然还能调用继承来的父类的成员）

         */

        //2.只能强转父类的引用，不能强转父类的对象
        F f = new S();
        S s = (S)f;


        //3.要求父类的引用必须指向的是当前目标类型的对象
        F f2 = new S2();
        S2 s2 = (S2)f2;//转换过后的类型必须 是 父类向上转型时的 本类 或者 本类的父类(转换后的形态还是向上转型)

        // 准确来说：转换过后的类型必须 是 父类向上转型的 父类或本类
        Object object = new S();
        F s3 = (F)object;

        //4. 当向下转型后，可以调用子类类型中所有的成员（此时当然还能调用继承来的父类的成员）
        System.out.println(s.n1);
        System.out.println(s.n2);
        s.m1();
        s.m2();
        s.m3();
        s.m4();
        // 当然强转后的 父类引用还可以使用
        //f.m3(); 当然此时还是向下转型的规则
        System.out.println(f.n1);
        f.m1();
    }
}

class F {
    public int n1 = 100;

    public void m1() {
        System.out.println("父类的 m1 方法");
    }

    public void m2() {
        System.out.println("父类的m2 方法");
    }
}

class S extends F {
    public int n2 = 200;

    public void m3() {
        System.out.println("子类的 m3 方法");
    }

    public void m1() {
        System.out.println("子类重写的 m1 方法");
    }

    public void m4() {
        super.m1();
        // 通过super+子类方法来调用父类被重写的方法
    }
}

class S2 extends F {

}