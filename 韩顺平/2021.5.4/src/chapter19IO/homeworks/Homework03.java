package chapter19IO.homeworks;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/chapter19IO/homeworks/dog.properties"));
        Dog dog = new Dog(properties.getProperty("name"),
                Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        // Integer.parseInt(str) String -> Integer 而Integer 自动拆箱为int
        System.out.println(dog);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream
                (new FileOutputStream("e:/dog.dat"));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream("e:\\dog.dat"));// 序列化和反序列化 只能在一个文件中
        //System.out.println((Dog)objectInputStream.readObject()); - 一个信息只能读取一次。
        //name等信息是存在Dog对象中的
        Dog dog1 = (Dog)objectInputStream.readObject();
        System.out.println(dog1.name);
        System.out.println(dog1.age);
    }
}

class Dog implements Serializable {
     String name;
     int age;
     String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}