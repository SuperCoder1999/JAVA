package chapter8oopintermediate.homeworks;

public class Homework13 {
    public static void main(String[] args) {

        Person13[] p = new Person13[4];
        p[0] = new Student13("Tom", '男', 13, 1902010160);
        p[1] = new Teacher13("Jack", '女', 27, 8);
        p[2] = new Student13("小明", '男', 19, 190283909);
        p[3] = new Teacher13("老王", '男', 45, 24);
        new Sort().BubbleSort13(p);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
        }

        Call call = new Call();
        for (Person13 ps : p) {
            call.call(ps);
        }
    }
}

class Call {
    public void call(Person13 ps) {
        if (ps instanceof Student13) {
            System.out.println(((Student13) ps).play());
            ((Student13) ps).study();
            //((Student13) ps).printInfo();
        } else if (ps instanceof Teacher13) {
            System.out.println(((Teacher13) ps).play());
            ((Teacher13) ps).teach();
            //((Teacher13) ps).printInfo();
        }
    }
}

class Sort {
    public void BubbleSort13(Person13[] p) {
        for (int i = 0; i < p.length - 1; i++) {
            boolean loop = true;
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].getAge() < p[j + 1].getAge()) {
                    Person13 p1 = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = p1;
                    loop = false;
                }
            }
            if (loop)
                break;
        }
    }
}

class Person13 {
    private String name;
    private char sex;
    private int age;

    public Person13(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return this.name + "爱玩";
    }

    @Override
    public String toString() {
        return "Person13{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public String basicInfo() {
        return "姓名：" + this.name + "\n性别：" + this.sex + "\n年龄：" + age;
    }
}

class Student13 extends Person13 {
    private double stu_id;

    public Student13(String name, char sex, int age, double stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public double getStu_id() {
        return stu_id;
    }

    public void setStu_id(double stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会认真学习");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    //编写一个输出信息的方法，这样体现封装
    public void printInfo() {
        System.out.println("-------- 学生信息 ---------");
        System.out.println(super.basicInfo());
        System.out.println("学号：" + this.stu_id);
        System.out.println(super.play() + this.play());
        this.study();
    }

}

class Teacher13 extends Person13 {
    private int work_age;

    public Teacher13(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会教书");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    //编写一个输出信息的方法，这样体现封装
    public void printInfo() {
        System.out.println("============ 教师信息 =========");
        System.out.println(super.basicInfo());
        System.out.println("学号：" + this.work_age);
        System.out.println(super.play() + this.play());
        this.teach();
    }

}