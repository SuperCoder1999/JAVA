package chapter8oopintermediate.poly;

public class PolyDetail01 {
    public static void main(String[] args) {
    /*
        一：多态细节
          1.多态的前提是：两个对象/类存在继承关系（如果是重载体现多态可以不考虑继承）

          2.多态的向上转型（如 polycase 中 Animal 和 Dog）
           1）本质：父类的引用指向了子类的对象
           2）语法：父类类型 引用名(对象名) = new 子类类型();
           3）特点：
             a.编译类型看等号左边，运行类型看等号右边
             b.可以调用父类中的所有成员、但需要遵从访问权限
               (编译时只能调用父类成员.这是由编译类型决定的。
                运行时可以通过方法重写而调用子类的方法)
             c.不能调用子类中特有成员--即重写的方法可以调用（归功于运行类型）
             d.最终运行效果看子类（运行类型）的具体实现。因为调用方法时，
               是按照从子类（运行类型）开始查找方法，这个顺序和继承细节中一致（文件 SuperDetail)

     */
        Person person = new Student();

        //编译时只能调用父类成员.这是由编译类型决定的。
        person.m2();

        //不能调用子类中特有成员
        //person.m3();

        // 重写的方法可以调用（归功于运行类型）
        person.m1();
    }
}

class Person {
    public int n1 = 100;

    public void m1() {
        System.out.println("父类的public void m1() 方法");
    }

    public void m2() {
        System.out.println("父类的public void m2() 方法");
    }
}

class Student extends Person {
    public int n1 = 200;

    public void m1() {
        System.out.println("子类的public void m1() 方法");
    }

    public void m3() {
        System.out.println("子类特有的public void m3() 方法");
    }
}
