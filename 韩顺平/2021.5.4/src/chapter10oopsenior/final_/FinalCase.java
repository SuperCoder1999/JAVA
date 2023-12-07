package chapter10oopsenior.final_;
/*
    一：使用于哪些情况
    1. 不希望类被继承时，可以用final修饰类：
        public final class FinalCase {}
    2. 不希望父类的某个方法被子类覆盖/重写时，可以用final修饰方法：
        public final void hi()
    3. 当不希望类的某个属性的值被修改，可以用final修饰类属性(即成员变量)（当有多个修饰符同时修饰时，看看java规范进行排序）
        public final double TAX_RATE = 0.08;
    4. 当不希望某个局部变量被修改可以用final修饰：
        final double NUM = 0.01;
        4.1 静态局部变量只能定义时赋值(分开写也行)。
    5. final修饰的引用
        final修饰的引用一旦指向一个对象，就不能在重新指向其他对象，虽然指向不能改变，但是该引用指向的对象内部的数据是可以修改的；
 */
public class FinalCase {

    public static void main(String[] args) {
        //final修饰局部的引用变量时，不能从对对象A的引用转移到对对象B的引用，但是对象A的内容可以变化。
        D d1 = new D();
        D d2 = new D();
        final D d = d1;
        //d = d2;

        E e = new E();
        //e.TAX_RATE = 0.09;
        G g = new G();
        g.TAX_RATE = 1;// 说明子类的属性是占用了新的空间，可能就是遵循就近原则，并不是final的作用。
    }
}

//如果我们要求A类不能被其他类继承
//可以使用final修饰 A类
final class A {
}

//class B extends A {}

class C {
    //如果我们要求hi不能被子类重写
    //可以使用final修饰 hi方法
    public final void hi() {
    }
}

class D extends C {
//    @Override
//    public void hi() {
//        System_.out.println("重写了C类的hi方法..");
//    }
}

//当不希望类的的某个属性的值被修改,可以用final修饰
class E {
    public final double TAX_RATE = 0.08;
     // 这种final修饰的属性相当于常量，一般全大写
}

//当不希望某个局部变量被修改，可以使用final修饰
class F {
    public void cry() {
        //这时，这种final修饰的局部变量相当于局部常量，一般全大写
        final double NUM = 0.01;
        //NUM = 0.9;
        System.out.println("NUM=" + NUM);
    }
}

class G extends E{
    public double TAX_RATE = 1;//说明子类的属性是占用了新的空间，可能就是遵循就近原则，并不是final的作用。
}