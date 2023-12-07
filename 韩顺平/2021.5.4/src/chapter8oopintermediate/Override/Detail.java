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
            5）静态方法没有多态重写
            6）抛出的异常必须是被重写方法抛出的异常，或者其父类异常
            7）充分必要条件：函数名、参数列表相同
            8）同名函数：方法名相同，参数列表不同。可以存在，这就是同名函数。可以理解为跨类的重载，添加@Override注解会报错
}
         */

        //2）子类需要重写的方法的返回类型和父类方法返回类型一样或是其父类
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

class Father {
    public static void h1() {
        System.out.println("12");
    }
}

class Son extends Father {
    public static void h1() {
        System.out.println("123");
    }//静态方法没有多态重写
}

class Father2 {
    /*private不能使用，继承遵循访问修饰符规则*/
    void h1() {
        System.out.println("12");
    }
}

class Son2 extends Father2 {
    @Override
    public  void h1() {
        System.out.println("123");
    }
}

class Father3 {
    public int i = 10;
    public void h1(int i) {
        System.out.println("12");
    }
}

class Son3 extends Father3 {
    //这只算是“同名函数”
    private void h1(int i, int j) {
        System.out.println("123");
    }
}