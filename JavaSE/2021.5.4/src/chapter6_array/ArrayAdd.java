package chapter6_array;

/**
 * 要求：实现动态的给数组添加元素效果，实现对数组扩容。ArrayAdd.java
 * 1.原始数组使用静态分配 int[] arr = {1,2,3}
 * 2.增加的元素4，直接放在数组的最后 arr = {1,2,3,4}
 * 3.用户可以通过如下方法来决定是否继续添加，添加成功，是否继续？y/n
 */

import java.util.Scanner;

public class ArrayAdd {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        boolean flag = true;
        while (flag) { // do - while 也可以实现
            int[] arrNew = new int[arr1.length + 1];
            for (int i = 0; i < arr1.length; i++) {
                arrNew[i] = arr1[i];
            }
            System.out.print("Enter add : ");
            int add = 0;
            Scanner myScanner = new Scanner(System.in);
            add = myScanner.nextInt();
            arrNew[arr1.length] = add;// 最好写成 arrNew[arrNew.length-1] = add
            arr1 = arrNew;
            System.out.print("\n--添加后：---");
            for (int i = 0; i < arr1.length; i++) {
                System.out.print(arr1[i] + " ");
            }
            System.out.print("\nEnter y/n: ");
            char key = myScanner.next().charAt(0);
            boolean flag2 = false;
            do {
                if (key == 'y')
                    flag2 = false;
                else if (key == 'n'){
                    flag2 = false;
                    flag = false;
                }
                else {
                    System.out.print("错误输入：");
                    key = myScanner.next().charAt(0);
                    flag2 = true;
                }
            } while (flag2);
        }

    }
}
