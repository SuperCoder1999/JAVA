package examination.day09;

public class Solution01 {
    public static void main(String[] args) {
        System.out.println(addAB(7, 14));
    }
    public static int addAB(int A, int B) {
        // write code here
        int a = 0;
        int b = 0;
        int m = 0;
        int sum = 0;
        int res = 0;
        int i = 0;
        while ( A != 0 || B != 0) {
            a = A % 2;
            b = B % 2;
            sum = a + b;
            if ((sum +m) % 2 == 1)
                res += (int)Math.pow(2, i);
            if ((sum + m) >= 2) {
                m=1;
            } else {
                m=0;
            }
            A /= 2;
            B /= 2;
            i++;
        }
        if (m == 1) {
            res += (int)Math.pow(2, i);
        }
        return res;
    }

    public static int addAB2(int A, int B) {
        // write code here
        int a = 0;
        int b = 0;
        int m = 0;
        int sum = 0;
        int res = 0;
        int i = 0;
        while ( A != 0 || B != 0) {
            a = A % 2;
            b = B % 2;
            sum = a + b;
            if ((sum +m) % 2 == 1)
                res += (int)Math.pow(2, i);
            if ((sum + m) >= 2) {
                m=1;
            } else {
                m=0;
            }
            A /= 2;
            B /= 2;
            i++;
        }
        if (m == 1) {
            res += (int)Math.pow(2, i);
        }
        return res;
    }
}
