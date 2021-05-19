package chapter5_control.homework;

/*
    // 我的做法
    import java.util.Scanner;

    public class HomeWork01 {
        public static void main(String[] args) {
            int money;
            int count = 0;
            Scanner myScanner = new Scanner(System.in);
            money = myScanner.nextInt();
            money = 100000;
            while (money >= 0) {
                if (money > 50000) {
                    money *= 0.95;
                    count++;
                } else{
                    money -= 1000;
                    count++;
                }
            }
            System.out.println(--count);
        }
    }
*/
// 视频做法
public class HomeWork01 {
    public static void main(String[] args){
        int money = 100000;
        int count = 0;
        while (true){
            if(money > 50000){
                money *= 0.95;
                count++;
            }
            else if(money > 1000) {
                money -= 1000;
                count++;
            }
            else
                break;
        }
        System.out.println("10000元能通过 " + count + " 个路口");
    }
}