package chapter6array;

/**
 * 动态创建下面二维数组，并输出
 *
 * 		 i = 0:	1
 * 		 i = 1:	2	2
 * 		 i = 2:	3	3	3
 */
public class TwoDimension02Array {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i+1];
        } //这两步可以合成一步
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        } //这两步可以合成一步
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
