package chapter14jihe.collection_.IterateOverCollection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 创建  3个 Dog {name, age}  对象，放入到 ArrayList 中，赋给 List 引用
 * 用迭代器和增强for循环两种方式来遍历
 * 重写Dog 的toString方法， 输出name和age
 */
public class Exercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("小黑", 3));
        list.add(new Dog("大黄", 100));
        list.add(new Dog("大壮", 8));

        // Iterator迭代器法遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("Iterator迭代器法遍历" + obj);
        }

        // 增强for循环遍历
        for (Object obj : list) {
            System.out.println("增强for循环遍历" + obj);
        }

    }
}

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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}