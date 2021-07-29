package homeworks.class3;

import java.util.Scanner;

/*
    年龄打印
    根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
 */

public class JudgeAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (!(age >=0 && age <= 160)) {
            System.out.println("输入年龄有误");
            return;
        }
        if (age < 18)
            System.out.println("是少年");
        else if (age < 28)
            System.out.println("是青年");
        else if (age < 55)
            System.out.println("是中年");
        else
            System.out.println("是老年");
    }
}
