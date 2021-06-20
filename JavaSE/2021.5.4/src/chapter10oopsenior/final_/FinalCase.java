package chapter10oopsenior.final_;
/*
    一：使用于哪些情况
    1. 不希望类被继承时，可以用final修饰：
        public final class FinalCase {}
    2. 不希望父类的某个方法被子类覆盖/重写时，可以用final修饰：
        public final void hi()
    3. 当不希望类的某个属性的值被修改，可以用final修饰（当有多个修饰符时，看看java规范）
        public final double TAX_RATE = 0.08;
    4. 当不希望某个局部变量被修改可以用final修饰：
        final double NUM = 0.01;
 */
public class FinalCase {

    public static void main(String[] args) {
        E e = new E();
        //e.TAX_RATE = 0.09;
        G g = new G();
        g.TAX_RATE = 1;// 说明子类的属性是占用了新的空间，和父类的属性没有关系。
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
//        System.out.println("重写了C类的hi方法..");
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
    public double TAX_RATE = 1;// 说明子类的属性是占用了新的空间，和父类的属性没有关系。
}