package chapter8oopintermediate.encapsulation;

/*
    请大家看一个小程序,
    不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。
    年龄合理就设置，否则给默认
    年龄, 必须在 1-120, 年龄\工资不能直接查看 ， name的长度在 2-6字符 之间
 */
public class EncapCase {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("S");
        person.setAge(121);
        person.setSalary(10000);
        System.out.println(person.name + " 的信息 "+ person.info());

        Person jack = new Person("Jack", 180, 20000);
        System.out.println(jack.name + " 的信息 "+ jack.info());


    }
}

class Person {
    String name;
    private int age;
    private int salary;

    // 如果有构造器，在构造器中进行封装
    public Person() {
        // 当创建其他构造器后，无参构造器需要显式定义
    }

    public Person(String name, int age, int salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // set 和 get 方法封装
    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        }
        else
            System.out.println("name 不合理");
    }

    public void setAge(int age) {
        if (age > 0 && age <= 120)
            this.age = age;
        else
            System.out.println("age范围错误");
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String info() {
        return "name: " + name + "  age=" +
                getAge() + "  salary=" + getSalary();
    }
}

class Employee {
    String name;
    int age;
    int salary;

    // 快捷键 alt + insert 快速创建 setXxx 和 getXxx

}