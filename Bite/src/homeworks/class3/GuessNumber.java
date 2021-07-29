package homeworks.class3;

import java.util.Scanner;

/*
    猜数字游戏
    完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序。
 */

public class GuessNumber {
    public static void main(String[] args) {
        int randomNum = (int)(Math.random() * 100);
        System.out.println("生成的随机数字是：" + randomNum);
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            num = scanner.nextInt();
            if (num == randomNum) {
                System.out.println("猜中了");
                break;
            }
            else if (num > randomNum)
                System.out.println("大了");
            else
                System.out.println("小了");
        }
    }
}
