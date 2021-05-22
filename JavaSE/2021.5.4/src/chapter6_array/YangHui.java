package chapter6_array;

public class YangHui {
    public static void main(String[] args) {
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++)  {
            arr[i] = new int[i+1];
        }
        for (int i = 0; i < arr.length; i++) { //可以在定义每一行长度时进行赋值
            for (int j = 0; j < arr[i].length; j++){
                if (j == 0)
                    arr[i][j] = 1;// 操作语句相同，判断语句可以写成 ||
                else
                    if (i == j)
                        arr[i][j] = 1;// 操作语句相同，判断语句可以写成 ||
                    else
                        arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
