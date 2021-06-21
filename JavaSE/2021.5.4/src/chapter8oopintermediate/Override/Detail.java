package chapter8oopintermediate.Override;

public class Detail {
    public static void main(String[] args) {
        /*
         1. 细节
            1）子类需要重写的方法的参数、方法名，要和父类方法的参数完全一致
            2）子类需要重写的方法的返回类型和父类方法返回类型一样或是父类返回类型
                的子类
            3)子类需要重写的方法的访问权限不能低于父类 public > protected > 默认 > private
            4)private 修饰的方法，在子类中不能重写
         */

        //2）子类需要重写的方法的返回类型和父类方法返回类型一样或是父类返回类型
        //   的子类
        S s = new S();// 系统提供的类关系
        s.m1();
        BB bb = new BB();// 自定义的类关系
        bb.m2();

        //3)子类需要重写的方法的访问权限不能低于父类
        BBB bbb = new BBB();
        bbb.m1();
        bbb.m2();
    }
}

class F {
    public Object m1() {
        System.out.println("F类的public Object m1() 方法");
        return null;
    }

}

class S extends F {
    public String m1() {
        System.out.println("S类的public String m1() 方法");
        return null;
    }
}

class AA {
    public Object m2() {
        System.out.println("AA类的public Object m2() 方法");
        return null;
    }
}

class BB extends AA {
    public String m2() {
        System.out.println("BB类的public Sting m2() 方法");
        return null;
    }
}

class AAA {
    public void m1() {
        System.out.println("AAA类的public void m1() 方法");
    }

    void m2() {
        System.out.println("AAA类的void m2()方法");
    }

}

class BBB {
    public void m1() {
        System.out.println("BBB类的public void m1() 方法");
    }

    protected void m2() {
        System.out.println("BBB类的protected void m2() 方法");
    }
}