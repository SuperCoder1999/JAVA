package chapter11enum_annotation.chapter10_11homework;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

/*
    1.有一个交通工具接口类Vehicles，有work接口
    2.有Horse类和Boat类分别实现Vehicles
    3.创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat
    4.有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
    5.实例化Person对象“唐僧”，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
    6.增加一个情况，如果唐僧过火焰山, 使用 飞机 ==> 程序扩展性, 我们前面的程序结构就非常好扩展 10min
    使用代码实现上面的要求
    编程 需求---->理解---->代码-->优化
 */
public class Homework06 {
    public static void main(String[] args) {
        Person tom = new Person("Tom", new Horse());
        tom.common();
        tom.passRiver();
        tom.passMountain();
        tom.common();
        tom.passRiver();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void common() {
        if (!(vehicles instanceof Horse))// 由于有构造器的原因，可能不需要再创建horse对象了
            vehicles = VehiclesFactory.getHorse();
        System.out.printf(name);
        vehicles.work();
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat))
            vehicles = VehiclesFactory.getBoat();
        System.out.printf(name);
        vehicles.work();
    }

    public void passMountain() {
        if (!(vehicles instanceof Plane))
            vehicles = VehiclesFactory.getPlane();
        System.out.printf(name);
        vehicles.work();
    }
}

class VehiclesFactory {
    private static Horse horse = new Horse();// 饿汉式单例设计模式
    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    private static Plane plane = new Plane();
    public static Plane getPlane() {
        return plane;
    }
}

interface Vehicles {
    public void work();
}

class Horse implements Vehicles {
    public void work() {
        System.out.println("一般情况下，用马前进");
    }
}

class Boat implements Vehicles {
    public void work() {
        System.out.println("过河时，坐船");
    }
}

class Plane implements Vehicles {
    public void work() {
        System.out.println("过火焰山，坐飞机");
    }
}
/*
public class Homework06 {
    public static void main(String[] args) {
        new Person("Tom", new Horse()).test();
        new Person("Jack", new Boat()).test();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void test() {
        System_.out.println(name + vehicles.work());
    }
}
interface Vehicles {
    public String work();
}

class Horse implements Vehicles {
    public String work() {
        return "骑马上班";
    }
}

class Boat implements Vehicles {
    public String work() {
        return "划船过河";
    }
}
 */