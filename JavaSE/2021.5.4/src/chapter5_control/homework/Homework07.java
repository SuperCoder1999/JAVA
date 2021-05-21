package chapter5_control.homework;

/**
 * //输出小写的a-z以及大写的Z-A
 */
public class Homework07 {
    public static void main(String[] args) {
        for (char i = 'a'; i <= 'z'; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (char j = 'Z'; j >= 'A'; j--){
            System.out.print(j + " ");
        }
    }
}
