package chapter8oopintermediate.homeworks;

public class Homework10 {
    public static void main(String[] args) {
        Doctor tom = new Doctor("Tom", 20, "主任", '男', 20000);
        Doctor smith = tom;
        Doctor jack = new Doctor("Jack", 29, "主刀医师", '男', 30000);
        System.out.println(tom.equals(jack));
        System.out.println(tom.equals(smith));
        jack = new Doctor("Tom", 20, "主任", '男', 20000);
        System.out.println(tom.equals(jack));
    }
}

class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job,char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Doctor) {
            Doctor doctor = (Doctor)obj;
            if (doctor.name.equals(this.name) && doctor.age == this.age && doctor.job.equals(this.job)
                    && doctor.gender == this.gender && doctor.sal == this.sal)
                return true;
        }
        return false;
    }
}