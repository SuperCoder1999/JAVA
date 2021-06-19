package chapter8oopintermediate.homeworks;

public class Homework03 {
    public static void main(String[] args) {
        Professor professor = new Professor("Jack", 28, "高级", 20000, 1.3);
        professor.introduce();
        Lecturer lecturer = new Lecturer("Tom", 30, "中级", 15000, 1.1);
        lecturer.introduce();
        Associate associate = new Associate("Smith", 40, "高级", 30000, 1.2);
        associate.introduce();
    }
}

class Teacher {
    private String name;
    private int age;
    private String post;
    private double salary;
    private double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void introduce() {
        System.out.println("name:" + this.name + "  age = " + this.age +
                "  post：" + this.post + "  salary = " + this.salary + "  级别：" + this.grade);
    }

}

class Professor extends Teacher {
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("这是教授类");
        super.introduce();
    }
}

class Lecturer extends Teacher {
    public Lecturer(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("这是讲师类");
        super.introduce();
    }
}

class Associate extends Teacher {
    public Associate(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    @Override
    public void introduce() {
        System.out.println("这是副教授类");
        super.introduce();
    }
}

