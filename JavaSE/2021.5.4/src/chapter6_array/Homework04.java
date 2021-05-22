package chapter6_array;

/**
 * 已知有个升序的数组，要求插入一个元素，该数组顺序依然是升序, 比如:
 * [10， 12， 45， 90],  添加23 后, 数组为 [10， 12，23， 45， 90]
 */

import java.util.Scanner;

public class Homework04 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        // 输入插入值
        int add = 0;
        System.out.print("Enter add: ");
        Scanner myScanner = new Scanner(System.in);
        add = myScanner.nextInt();
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (add <= arr[i]) {
                index = i;
                break;
            }
        }
        if (index == -1)
            index = arr.length;
        // 可以先输出下标看看是否正确
        System.out.print(index + "\n");
        // 插入
        int[] arrNew = new int[arr.length + 1];
            for (int i = 0, j = 0; i < arrNew.length; i++) {
                if (i != index) {
                    arrNew[i] = arr[j];
                    j++;
                } else
                    arrNew[i] = add;
            }
            arr = arrNew;
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
    }
}
//        // 可以先输出下标看看是否正确
//        System.out.print(index + "\n");
//        int[] arrNew = new int[arr.length + 1];
//        if (index == -1) {
//            for (int i = 0; i < arr.length; i++) {
//                arrNew[i] = arr[i];
//            }
//            arrNew[arr.length] = add;
//        } else
//            for (int i = 0, j = 0; i < arr.length; i++, j++) {
//                if (index == j) {
//                    arrNew[j++] = add;
//                    i--;
//                } else
//                    arrNew[j] = arr[i];
//            }
//        arr = arrNew;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

//        // index != arr.length-1 的情况
//        if (index == arr.length) {
//            for (int i = 1; i < arr.length; i++) {
//            arrNew[i] = arr[i];
//            }
//            arrNew[arrNew.length - 1] = add;
//        }
//        else
//        for (int i = 0, j = 0; i < arr.length; i++, j++) {
//            if (j == index) {
//                arrNew[j++] = add;
//            }
//            else
//                arrNew[j] = arr[i];
//        }
//        arr = arrNew;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

