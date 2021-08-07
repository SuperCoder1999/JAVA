package homeworks.class8;

/*
作业标题
交换两个数组

作业内容
给定两个整型数组, 交换两个数组的内容.
 */

public class ExchangeArray {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};

        int[] arr2 = {11, 22, 33, 44, 55};

        System.out.println("原始的两个数组:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }

        exchangeArray(arr1, arr2);

        System.out.println("\n交换后的两个数组:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }
    }

    public static void exchangeArray(int[] arr1, int[] arr2) {
        //int[] temp = new int[arr1.length];不需用一整个数组，一个整型变量即可
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }
    }
}