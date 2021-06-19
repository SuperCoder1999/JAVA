package chapter8oopintermediate.object.equals;

public class Exercise01 {
    public static void main(String[] args) {
        Person person1 = new Person("Jack", 18, '男');
        Person person2 = new Person("Smith", 10, '男');
        Person person3 = new Person("Jack", 18, '男');
        System.out.println(person1.equals(person2));// 没有重写equals的情况下用的是Object的equals方法
        System.out.println(person3.equals(person1));

    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Person) {
            Person person = (Person)obj;
            return this.name.equals(person.name) && this.age == person.age && this.gender == person.gender;
        }
        return false;// 没有 else 才是源代码中标准的格式
    }
}