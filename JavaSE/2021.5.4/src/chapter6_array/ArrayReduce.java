package chapter6_array;

import java.util.Scanner;
public class ArrayReduce {
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 5};


        //提示是否缩减
        System.out.print("是否缩减:(y/n)");
        Scanner myScanner = new Scanner(System.in);
        char choise = myScanner.next().charAt(0);
        boolean flag = true;
        if (choise == 'y')
            flag = true;
        else
            flag = false;
        while (flag) {
            // 判断是否只剩一个元素
            if (arr.length == 1) {
                System.out.println("no 元素");
                break;
            }
            //缩减
            int[] arrNew = new int[arr.length-1];
            for (int i = 0; i < arrNew.length; i++) {
                arrNew[i] = arr[i];
            }
            arr = arrNew;
            //显示缩减后的
            System.out.println("\n缩减后的：");
            for (int i = 0; i <arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            // 再次判断缩减
            System.out.print("\n是否缩减:(y/n)");
            choise = myScanner.next().charAt(0);
            if (choise == 'y')
                flag = true;
            else
                flag = false;
        }
        System.out.println("Exit");
    }
}
