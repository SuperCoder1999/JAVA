package chapter10oopsenior.Template;

/*
    抽象模板模式
 */

public class TestTemplate {
    public static void main(String[] args) {
        new AA().calculateTime();
        new BB().calculateTime();
    }
}

abstract class Template {

    //子类需要重写的方法的返回类型和父类方法返回类型一样或是父类返回类型的子类.
    // 所以父类可以尽量扩大返回类型，方便子类重写
    public abstract void job();

    public void calculateTime() {
        // 统计当前时间距离1970-1-1 00:00:00 的时间差，单位ms
        long start = System.currentTimeMillis();

        job();// 这里有动态绑定机制，根据创建对象的运行类型找到子类的该方法

        long end = System.currentTimeMillis();
        System.out.println("任务执行时间 " + (end - start));
    }
}

class AA extends Template{
    public void job() {
        for (int i = 0; i < 1e8; i++) {
            ;
        }
    }
}

class BB extends Template {
    public void job() {
        for (int i = 0; i < 1000000; i++) {
            ;
        }
    }
}

