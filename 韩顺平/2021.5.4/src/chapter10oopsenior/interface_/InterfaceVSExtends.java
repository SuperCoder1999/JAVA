package chapter10oopsenior.interface_;

/*
    一：实现接口和继承类的比较
    1. 继承的价值的价值在：解决代码的复用性和可维护性（可维护性暂时不知怎么理解）
    2. 接口的价值在：设计好各种规范（方法），让其他类来实现这些方法
    3.  实现接口 是 对java 单继承机制的一种补充.
    4. 接口在一定程度上实现代码解耦【即：接口规范性+动态绑定机制】
 */
public class InterfaceVSExtends {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("悟空");
        wuKong.climbing();
        wuKong.swimming();
        wuKong.flying();
    }
}

//猴子
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing() {
        System.out.println(name + " 会爬树...");
    }

    public String getName() {
        return name;
    }
}

//接口
interface Fishable {
    void swimming();
}

interface Birdable {
    void flying();
}

//继承
//小结:  当子类继承了父类，就自动的拥有父类的功能
//      如果子类需要扩展功能，可以通过实现接口的方式扩展.
//      可以理解 实现接口 是 对java 单继承机制的一种补充.
class LittleMonkey extends Monkey implements Fishable, Birdable {

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + " 通过学习，可以像鱼儿一样游泳...");
    }

    @Override
    public void flying() {
        System.out.println(getName() + " 通过学习，可以像鸟儿一样飞翔...");
    }
}