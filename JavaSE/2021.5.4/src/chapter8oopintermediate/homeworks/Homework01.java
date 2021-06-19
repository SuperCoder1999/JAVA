package chapter8oopintermediate.homeworks;

public class Homework01 {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("Jack", 18, "公务员");
        persons[1] = new Person("Smith", 20, "教授");
        persons[2] = new Person("Tom", 10, "学生");

        for (int i = 0; i < persons.length - 1; i++) {//比较了length-1次
            boolean loop = true;
            for (int j = 0; j < persons.length - i -1; j++) {//j 一定从 0 到 persons.length-2（persons.length是没有元素的）
                if (persons[j].getAge() < persons[j+1].getAge()) {
                    // Person person = new Person();//必须把无参构造器补上
                    Person person = null;// 创建对象名而不指向任何对象
                    person = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = person;

//                    int temp = persons[j].getAge();
//                    persons[j].setAge(persons[j+1].getAge());
//                    persons[j+1].setAge(temp);// 仅仅更改了年龄。破坏了每个对象的属性
                    loop = false;
                }
            }
            if (loop)
                break;
        }

        for (Person i : persons) {
            System.out.println(i);
        }
    }
}

class Person {
    private String name;
    private int age;
    private String job;

    public Person() {

    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    void fun() {
        System.out.println("person");// 用于验证默认修饰符的同包访问性
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
