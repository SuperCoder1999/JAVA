package chapter9houserent.houserent_exercise;

import java.util.Scanner;

public class HouseRentOOP {
    String choice = "";
    Boolean loop = true;
    String[][] house = new String[100][5];
    int count = 0;
    String name;
    double tel;
    String loc;
    double price;
    String status;

    Scanner scanner = new Scanner(System.in);

    public void test() {
        do {
            this.menu();
            choice = scanner.next();
            switch (choice) {
                case "1":
                    this.addHouse();
                    break;
                case "2":
                    System.out.println("\t\t\t\t2 查找房屋");
                    break;
                case "3":
                    System.out.println("\t\t\t\t3 删除房屋");
                    break;
                case "4":
                    System.out.println("\t\t\t\t4 修改房屋信息");
                    break;
                case "5":
                    System.out.println("\t\t\t\t5 房屋列表");
                    break;
                case "6":
                    loop = false;
                    System.out.println("\t\t\t\t6 退 出");
                    break;
            }
        } while (loop);
    }

    public void menu() {
        System.out.println("----------------- 房屋出租系统 ----------------");
        System.out.println("\t\t\t\t1 新增房源");
        System.out.println("\t\t\t\t2 查找房屋");
        System.out.println("\t\t\t\t3 删除房屋");
        System.out.println("\t\t\t\t4 修改房屋信息");
        System.out.println("\t\t\t\t5 房屋列表");
        System.out.println("\t\t\t\t6 退 出");
        System.out.println("输入选项：");
    }

    public void addHouse() {
        System.out.print("姓名：");
        this.name = scanner.next();
        System.out.print("电话：");
        this.tel = scanner.nextDouble();
        System.out.print("地址：");
        loc = scanner.next();
        System.out.print("月租：");
        price = scanner.nextDouble();
        System.out.print("状态：");
        status = scanner.next();
        //house[count][0] =
    }
}
