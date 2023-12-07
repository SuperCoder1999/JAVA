package chapter8oopintermediate.poly.dynamicbinging;

/**
 * @author NieJian
 * @date 2022/12/19 23:22
 * @Description
 * 1.在类外面, 调用方法, 只能调用编译类型中声明的方法, 执行的是运行类型中的方法.
 * 2. 在类外面调用属性,和调用方法一样,只能调用编译类型中声明的成员属性.由于没有动态绑定,所以属性的值就是编译类型所在类的属性值(对象属性/静态方法没有多态,所以就没有动态绑定)
 * 3在类中.不论使不使用this关键字调用属性.只能调用当前类声明的属性,运行时也是当前类中为属性声明的值(即也属性没有继承机制)
 * 4.在类中,不论使不使用this关键字调用本类或父类的成员方法.,执行的是运行类型中的方法(运行类型的父类中的this指代子类实例)
 */
public class DynamicBinding {
    public static void main(String[] args) {
        Father father = new Son();
        father.test();
    }
}

class Father {

    public int aa = 1;

    public int a = 11;

    public void test() {
        System.out.println(this.aa);
        System.out.println(aa);
        test01();
        System.out.println("this: " + this);//this: Son@63947c6b
        this.test02();
        //不要忘记继承机制,调用子类方法,是可以调用子类的父类中的方法.
        this.test03();//这里在本质上是调用this的运行类型的父类的方法
    }

    public void test01() {
        System.out.println("AA-test01()");
    }

    public void test02() {
        System.out.println("AA-test02()");
    }

    public void test03() {
        System.out.println("AA-test03()");
    }
}

class Son extends Father {

    public int aa = 2;

    @Override
    public void test01() {
        System.out.println("BB->test01()");
    }
    @Override
    public void test02() {
        System.out.println("BB->test02()");
    }
}