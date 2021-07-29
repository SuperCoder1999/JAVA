package homeworks.class3;

/*
    输出闰年
    输出 1000 - 2000 之间所有的闰年
 */

public class LeapYear {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1000; i <= 2000; i++) {
            if (isLeapYear(i)) {
                System.out.print(i + " ");
                count++;
                if (count % 10 == 0)
                    System.out.println();// 需要在if内部
            }
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        return false;
    }
}
