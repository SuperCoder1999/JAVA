package chapter10oopsenior.single;

/*
    一：饿汉式定义：
    饿汉式就是指一旦加载类信息就立即创建对象


    二：如何保障我们只能创建一个 GirlFriend 对象
    步骤[单例模式-饿汉式]
    1. 将构造器私有化
    2. 在类的内部直接创建对象(该对象是static)
    3. 提供一个公共的static方法，返回 p 对象

    三：缺点
    存在资源浪费的可能

    四：两者区别：
      创建对象的时机不同
 */
public class SingleHunger {
    public static void main(String[] args) {
        System.out.println(Friend.n1);//饿汉式就是指一旦加载类信息就立即创建对象
        System.out.println(Person.getInstance());
    }
}

class Person {
    private String name;

    public static int n1 = 100;

    private static Person p = new Person("小红");
        //这里必须是static否则，在getInstance中无法调用
    private Person(String name) {
        this.name = name;
    }

    public static Person getInstance() {
        return Person.p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
