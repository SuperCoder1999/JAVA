package chapter7_ObjectOrientedProgramming.VariableParameter;

/*
	有三个方法，分别实现返回姓名和两门课成绩(总分)，
	返回姓名和三门课成绩(总分)，返回姓名和五门课成绩（总分）。
	封装成一个可变参数的方法
	 */
public class VarParameterExercise {
    public static void main(String[] args) {
        Score aScore = new Score();
        aScore.showScore("jake", 99, 100, 98.5);
        aScore.showScore("tom",60, 65, 67.5);
    }
}

class Score {
    public void showScore(String name, double... scores) {
        double res = 0;
        for (double score : scores) {
            res += score;
        }
        System.out.println("name: " + name + " totalScore= " + res);
    }
}
