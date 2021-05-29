package chapter7oopprimary.Method;

public class MethodParameter02 {
    public static void main(String[] args) {
        Person aPerson = new Person();
        B aB = new B();
        aPerson.age = 100;
        aB.test200(aPerson);
        System.out.println(aPerson.age);
    }
}

class Person {
    String name;
    int age;
}

class B {
    public void test200(Person aPerson) {
        aPerson = null;// main 和 此处的 aPerson 是不同的 空间中的变量
    }
}
