package chapter10oopsenior.innerclass.localinnerclass;
/*
  一：演示局部内部类的使用细节
  1. 局部内部类可以直接访问外部类的所有成员，包含私有的
  2. 作用域（本质是局部变量）：仅仅在定义它的方法体或代码块中【出了这个范围，即使连实例化内部类都不行】
  3. 不能添加访问修饰符，因为它的地位就是局部变量。而局部变量是不能使用修饰符，
   但是可以使用final修饰，因为局部变量也可以使用final（使用了final之后，在定义内部类的方法体中就不能有类继承它了）
  4. 外部类访问局部内部类的成员方式：
    （只能在定义该内部类的方法体内调用内部类的成员）
      创建对象，再访问（必须在作用域内）
  5. 内部类本质还是一个类，所以可以被继承（必须在作用域内）
  6. 外部其他类（出了作用域）就不能访问局部内部类了（本质是局部变量）
  7. 如果外部类和局部内部类的成员重名时，遵循就近原则。如果想访问外部类的成员，
  则可以使用 （外部类名.this.成员) 来访问

 */
public class LocalInnerClass {//
    public static void main(String[] args) {
        //演示一遍
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode=" + outer02);
    }
}


class Outer02 {//外部类
    private int n1 = 100;
    private void m2() {
        System.out.println("Outer02 m2()");
    }//私有方法
    public void m1() {//方法
        //1.局部内部类是定义在外部类的局部位置,通常在方法
        //3.不能添加访问修饰符,但是可以使用final 修饰
        //4.作用域 : 仅仅在定义它的方法或代码块中
        final class Inner02 {//局部内部类(本质仍然是一个类)
            //2.可以直接访问外部类的所有成员，包含私有的
            private int n1 = 800;
            public void f1() {
                //5. 局部内部类可以直接访问外部类的成员，比如下面 外部类n1 和 m2()
                //7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，
                //   使用 外部类名.this.成员）去访问
                //   老韩解读 Outer02.this 本质就是外部类的对象, 即哪个对象调用了m1, Outer02.this就是哪个对象
                System.out.println("n1=" + n1 + " 外部类的n1=" + Outer02.this.n1);
                System.out.println("Outer02.this hashcode=" + Outer02.this);
                m2();
            }
        }


        //6. 外部类在方法中，可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }

    //由于范围超出定义它的方法体，所以无法实例化
//    public void m3() {
//        Inner02 inner02 = new Inner02();
//    }

//Inner02本质就是类，可以在另一个局部内部类中继承；外部类（除了局部范围内都不能）无法继承内部类
//        class Inner03 extends Inner02 {
//
//
//        }
}

//class Other02 extends Inner02{//外部类（除了局部范围内都不能）无法继承内部类
//
//}