package chapter6array;

/**
 *      随机生成10个整数(1_100的范围)保存到数组，
 * 		并倒序打印以及求平均值、求最大值和最大值的下标、
 * 		并查找里面是否有 8
 */
public class Homework06 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        // (int)(Math.random()*100 + 1 生成随机数 1-100
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100 + 1);
        }
        // 显示 随机数
        System.out.print("随机数：\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 倒序打印  同时求平均值、最大值最小值的下标  查找 8
        double sum = 0;
        int maxIndex = 0;
        int minIndex = 0;
        int key = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
            if (arr[maxIndex] < arr[i])
                maxIndex = i;
            if (arr[minIndex] > arr[i])
                minIndex = i;
            if(arr[i] == 8)
                key = 1;
        }
        System.out.println("\n" + sum/arr.length);
        System.out.println("max: " + maxIndex + "min: " + minIndex);
        if (key == 1){
            System.out.println("have 8 ");
        }
        else
            System.out.print("not have 8");
    }
}
