package chapter10oopsenior.innerclass.anonymousinnerclass;

/*
    一：匿名内部类的最佳实践
    用作：实参直接传递，具有简洁高效的作用
 */
public class UsageCase {

    public static void main(String[] args) {

        //当做实参直接传递，简洁高效
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一副名画~~...");
            }
        });
        //传统方法
        f1(new Picture());

    }

    //静态方法,形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}

//接口
interface IL {
    void show();
}

//传统方式 ：编写一个类->实现IL => 在编程领域称为 ：硬编码
class Picture implements IL {

    @Override
    public void show() {
        System.out.println("这是一副名画XX...");
    }
}
