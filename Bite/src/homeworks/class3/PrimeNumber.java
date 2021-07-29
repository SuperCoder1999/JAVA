package homeworks.class3;

/*
    打印素数
    打印 1 - 100 之间所有的素数
 */

public class PrimeNumber {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i != 1 && isPrimeNumber(i)) {
                System.out.print(i + "\t");
                count++;
                if (count % 10 == 0)
                    System.out.println();
            }
        }
    }
        public static boolean isPrimeNumber ( int i){
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    return false;
            }
            return true;
        }
}