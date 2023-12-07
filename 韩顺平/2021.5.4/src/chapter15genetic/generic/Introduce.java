package chapter15genetic.generic;
import java.util.ArrayList;

/*
    一：引出泛型
    1. 如果没有泛型，就不能对加入集合ArrayList中的数据类型进行约束（不安全）
    2. （增强for）遍历的时候，必须进行类型转换（即使当所有元素都是同一类型时）
        当集合中数据量较大时，对效率有影响

    二：泛型的优点
    1. 编译时，检查添加元素的类型，提高了安全性
    2. 减少了类型转换的次数，提高效率：
        1）不适用泛型：
        Dog 加入时：Dog 需要转化-> Object
        Dog 取出时：Object 需要转化-> Dog
        2）使用泛型
        Dog 加入时：Dog
        Dog 取出时：Dog
    3. 猜测总结：有了泛型后，程序就做了优化，直接跳过向上转型到Object的过程，而是直接转型到 要求的类型

    三：泛型的介绍
    1. 泛(广泛)型(类型)的理解：泛型就是 存放类型 的类型 ： E = Integer,String,Dog;之后E就可以代表这些类型。
    2. 泛型又称为参数化类型，是Jdk5.0出现的新特性，解决数据类型的安全性问题。
    3. 在类声明(定义一个类<E>)或实例化(传入泛型要被赋值的类型<Dog>)时只要指定好需要的具体的类型即可。
    4. Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简介、健壮。
    5. 泛型的作用：可以在类声明时通过一个标识<E>表示类中某个属性的类型，或者是某个方法的返回值的类型，或者是参数类型。
       所以泛型作用于：属性、局部变量、方法、参数类型（传入的形参）

   四：泛型的语法
   1. 泛型的声明
   interface 接口名<T,E...>{} 和 class 类名<K,V,E...>{}
   说明：
    1）T，V，E不代表值，而是存放类型的形参，用于接收传入的类型
    2）任意字母都可以。常用T表示，是Type的缩写

    2. 泛型的实例
    要在类名后指定类型参数的值(即传入类型)
    1）List<String> strList = new ArrayList<String>();
    2)Iterator<Customer> iterator = customers.iterator();
     说明：
        1)传入类型实参的类/接口必须有接收的形参，即需要泛型的声明
        2)声明了多少泛型形参，就要传入多少个

 */

@SuppressWarnings({"all"})
public class Introduce {
    public static void main(String[] args) {

        //使用传统的方法来解决===> 使用泛型
        //老韩解读
        //1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是Dog类型 (细节后面说...)
        //2. 如果编译器发现添加的类型，不满足要求，就会报错
        //3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        //4. public class ArrayList<E> {} E称为泛型,那么 Dog 类似于传参给 E
        // Dog 在编译时都会替换 E （即E就代表了Dog）
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        //假如我们的程序员，不小心，添加了一只猫
        //arrayList.add(new Cat("招财猫", 8));
        System.out.println("===使用泛型====");

        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}

/*
1.请编写程序，在ArrayList 中，添加3个Dog对象
2.Dog对象含有name 和 age, 并输出name 和 age (要求使用getXxx())
3.老师使用泛型来完成代码
 */
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat { //Cat类
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/*
 // 传统方式 --- 引子
@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {

        //使用传统的方法来解决
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));

        //假如我们的程序员，不小心，添加了一只猫
        arrayList.add(new Cat("招财猫", 8));

        //遍历
        for (Object o : arrayList) {
            //向下转型Object ->Dog
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

    }
}

//请编写程序，在ArrayList 中，添加3个Dog对象
//Dog对象含有name 和 age, 并输出name 和 age (要求使用getXxx())

class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat { //Cat类
    private String name;
    private int age;
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
 */