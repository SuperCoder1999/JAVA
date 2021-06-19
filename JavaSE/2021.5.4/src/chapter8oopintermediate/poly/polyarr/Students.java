package chapter8oopintermediate.poly.polyarr;

public class Students extends Person {
    private int score;

    public Students(String name, int age, int score) {
        super(name, age);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String say() {
        return "学生 " + super.say() + "  " +  score;
    }

    // 特有方法
    public void stay() {
        System.out.println(getName() + "正在学习");
    }
}
