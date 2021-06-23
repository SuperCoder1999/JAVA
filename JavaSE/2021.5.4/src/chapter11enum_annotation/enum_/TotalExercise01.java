package chapter11enum_annotation.enum_;

/*
    一：题目要求：
        声明Week枚举类，其中包含星期一至星期日的定义；
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        使用values 返回所有的枚举数组, 并遍历 , 输出左图效果
 */
public class TotalExercise01 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for (Week day : weeks) {
            System.out.println(day);
        }
    }
}

enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");
    private String day;

    Week(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    @Override
    public String toString() {
        return day;
    }
}