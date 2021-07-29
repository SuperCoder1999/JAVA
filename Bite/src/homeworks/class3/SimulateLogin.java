package homeworks.class3;

import java.util.Scanner;

/*
    模拟登陆
    编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误，
    可以重新输 入，最多输入三次。三次均错，则提示退出程序

 */

public class SimulateLogin {
    public static void main(String[] args) {

        String password = "N1234567890";//正确的密码

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入密码：");
        for (int i = 0; i < 3; i++) {
            String myPassword = scanner.nextLine();
            if (myPassword.equals(password)) {
                System.out.println("登录成功");
                return;
            }
            else {
                System.out.println("密码错误,重新输入：");
            }
        }
        System.out.println("三次机会用完，程序退出");
    }
}
