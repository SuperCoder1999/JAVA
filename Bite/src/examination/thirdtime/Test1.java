package examination.thirdtime;

/*
//这里用桶排序，得到的是不按照源字符串顺序找到目标字符。
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] tong1 = new byte[52];
        byte[] tong2 = new byte[52];
        String str = scanner.next();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] <= 'z' && bytes[i] >= 'a') {
                int index = bytes[i] - 71;
                if (tong2[index] == 0) {
                    tong1[index] =
                }
            }
        }
    }
}*/
/*
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = new char[100];
        byte[] bytes = str.getBytes();
        int count = 0;
        for (int i = 0; i < bytes.length; i++) {
            boolean flag = true;
            for (int j = 0; j < count; j++) {
                if (chars[j] == bytes[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                chars[count] = (char)bytes[i];
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.printf("%c", chars[i]);
        }
    }
}
*/
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            char[] chars = new char[100];
            byte[] bytes = str.getBytes();
            int count = 0;
            for (int i = 0; i < bytes.length; i++) {
                boolean flag = true;
                for (int j = 0; j < count; j++) {
                    if (chars[j] == bytes[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    chars[count] = (char) bytes[i];
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                System.out.printf("%c", chars[i]);
            }
            System.out.println();//就是少了一个换行的符号。
        }
    }
}