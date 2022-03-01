package WinterHomeworks.day04.solution;

public class Solution01 {
    public static void main(String[] args) {
        isHappy(2);
    }
    public static boolean isHappy(int n) {
        //暴力,循环判断 10次
        int res = 0;
        for (int i = 0; i < 10; i++) {

            while (n != 0) {
                res = (n % 10) * (n % 10);
                n /= 10;
            }
            n = res;
            if (n == 1)
                return true;
        }
        return false;
    }
}
