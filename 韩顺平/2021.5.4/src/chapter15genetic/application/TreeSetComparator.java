package chapter15genetic.application;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/4/6 12:09
 * Description 泛型的应用: 将方法形参变量声明为具有下限的泛型范围
 */
public class TreeSetComparator {
    public static void main(String[] args) {
        //TreeSet<Cat> treeSet = new TreeSet<>(new Comparator2());
        TreeSet<Cat> treeSet = new TreeSet<Cat>(new Comparator1());
        treeSet.add(new Cat("jerry",20));
        treeSet.add(new Cat("amy",22));
        treeSet.add(new Cat("frank",35));
        treeSet.add(new Cat("jim",15));
        for (Cat cat : treeSet) {
            System.out.println(cat);
        }
    }
}

class Comparator1 implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Comparator2 implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        return o1.age - o2.age;
    }
}

class Comparator3 implements Comparator<MiniCat> {
    @Override
    public int compare(MiniCat o1, MiniCat o2) {
        return o1.level - o2.level;
    }
}

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Cat extends Animal {
    public int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class MiniCat extends Cat {
    public int level;

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "level=" + level +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}