package examination.simulated_written_test;

import java.util.Scanner;

public class Solution01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] c = str.toCharArray();
        int count = 0;
        int max = 0;
        String s = null;

        for (int i = 0; i < c.length; i++) {
            count = 0;
            String res = "";
            while (c[i] >= 'a' && c[i] <= 'z' || c[i] <= 'Z' && c[i] >= 'A')
                i++;
            while (i < c.length && c[i] <= '9' && c[i] >= '0') {
                res += c[i];
                count++;
                i++;
            }
            if (max < count) {
                max = count;
                s = res;
            }
        }
        System.out.println(max);
        System.out.println(s);
    }
}
