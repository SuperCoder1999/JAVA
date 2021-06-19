package chapter8oopintermediate.smallchange;

import java.util.Scanner;

public class SmallChangeExercise {
    public static void main(String[] args) {
        int choice;
        Change change = new Change();
        int count = 0;
        double balance = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            new Menu().menu();
            choice = scanner.nextInt();
            if (choice == 1)
                new Detail().print(change.arr, count);
            else if (choice == 2){
                System.out.println("输入入账金额");
                Scanner scanner1 = new Scanner(System.in);
                double income = scanner.nextDouble();
                balance += income;
                new Income().income(change.arr, count, income, balance);
                count++;
            }
            else if(choice == 3) {
                System.out.println("输入消费项目：");
                Scanner scanner2 = new Scanner(System.in);
                String note = scanner2.nextLine();
                System.out.println("输入消费金额：");
                Scanner scanner3 = new Scanner(System.in);
                double pay = scanner3.nextDouble();
                balance -= pay;
                new Pay().pay(change.arr, count, note, pay, balance);
                count++;
            }
        } while (choice != 4);
    }
}

class Menu {
    public void menu() {
        System.out.println("------------------------- 零钱通菜单 ----------------------");
        System.out.println("\t\t\t1 零钱通明细");
        System.out.println("\t\t\t2 收益入账");
        System.out.println("\t\t\t3 消 费");
        System.out.println("\t\t\t4 退 出");
    }
}

class Detail {
    public void print(String[] arr, int count) {
        System.out.println("------------------------- 零钱通明细 ----------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Income {
    public void income(String[] arr, int count, double income, double balance) {
        arr[count] = "收益入账  +" + income + "  2021 - 6- 18  " + "余额:" + balance;
    }
}

class Pay {
    public void pay(String[] arr, int count, String note, double pay, double balance) {
        arr[count] = note + "  -" + pay + "  2021-6-18  " + "余额：" + balance;
    }
}

class Change {
    String[] arr = new String[100];
}
