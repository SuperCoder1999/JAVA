package chapter7objectorientedprogrammingprimary.This;

/*
    定义Person类，里面有name、age属性，并提供compareTo比较方法，
    用于判断是否和另一个人相等，提供测试类TestPerson用于测试,
    名字和年龄完全一样，就返回true, 否则返回false
 */
public class ThisExercise {
    public static void main(String[] args) {
        TestPerson aTestPerson = new TestPerson("Jack", 19);
        TestPerson bTestPerson = new TestPerson("Jack",19);
        TestPerson cTestPerson = new TestPerson("Jack",20);
        TestPerson dTestPerson = new TestPerson("jack",19);
        System.out.println(aTestPerson.compareTo(bTestPerson));
        System.out.println(aTestPerson.compareTo(cTestPerson));
        System.out.println(aTestPerson.compareTo(dTestPerson));
    }
}

class TestPerson {

    String name;
    int age;

    public TestPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(TestPerson p) {
        return p.name.equals(this.name) && p.age == this.age;
        //return this.name.equals(p.name) && this.age == p.age;
    }
}

/*
public class ThisExercise {
    public static void main(String[] args) {

        TestPerson aTestPerson = new TestPerson("Jack", 19);
        System.out.println(aTestPerson.compareTo("Jack", 19));
        System.out.println(aTestPerson.compareTo("Mack", 19));

    }
}

class TestPerson {

    String name;
    int age;

    public TestPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareTo(String name, int age) {
        if (this.name == name && this.age == age)
            return true;
        else
            return false;
    }
}
 */