package chapter8oopintermediate.smallchange;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SmallChangeSys {
    public static void main(String[] args) {

        double balance = 0;//余额
        String key = "";// 对菜单的选择.为什么选择String类型。有待讨论
        boolean loop = true;// 控制do-while的结束
        String detail = "--------------------- 零钱通明细 -------------------";
        //零钱通明细有三种方式进行存储：1.数组（可是不知道数组长度，有点像C语言中的动态数组) 2.类（像链表） 3.字符串拼接
        String note = "";// 老师是写在外面的
        double money = 0;


        Scanner scanner = new Scanner(System.in);// 一次创建可以在不同语句中用。不冲突
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 显示菜单
        do {
            System.out.println("--------------------- 零钱通菜单 -------------------");
            System.out.println("1 零钱通明细");
            System.out.println("2 收益入账");
            System.out.println("3 消 费");
            System.out.println("4 退 出 ");
            System.out.println("输入选择：");
            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.print("输入收入金额：");
                    money = scanner.nextDouble();
                    // 验证输入金额
                    if (money < 0) {
                        System.out.println("输入错误,应该大于零");
                        break;
                    }
                    balance += money;
                    date = new Date();// 获得当前时间.必须放在这里，因为实时更新时间
                    detail += "\n收益入账  +" + money + "  " + sdf.format(date) + "  余额:" + balance;
                    break;
                case "3":
                    System.out.println("支出备注：");
                    note = scanner.next();//输入字符串
                    System.out.println("支出金额：");
                    money = scanner.nextDouble();
                    // 验证输入金额
                    if (money < 0 || money > balance) {
                        System.out.println("金额错误，应当在 0 - " + balance);
                        break;
                    }
                    balance -= money;
                    date = new Date();
                    detail += "\n" + note + "  -" + money + "  " + sdf.format(date) + "  余额：" + balance;
                    break;
                case "4":
                    String choice = "";// 也有放在内部的属性声明
                    // 添加确认退出程序
                    do {
                        System.out.println("确认退出(y/n):");
                        choice = scanner.next();
                    } while (!"y".equals(choice) && !"n".equals(choice));// 字符串之间不能用 == 判断。那是在判断是否是同一对象
                    // 这个while循环只解决输入正确性这一个功能，有效降低耦合性
                    if ("y".equals(choice))
                        loop = false;
                    break;
            }
        } while (loop);
        System.out.println("成功退出程序");
    }
}
