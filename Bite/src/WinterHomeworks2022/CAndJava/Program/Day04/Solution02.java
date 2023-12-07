package WinterHomeworks2022.CAndJava.Program.Day04;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/9 18:11
 * Description 小算法 => 对角线上元素值累加
 *              => 对角线表达式row == colum || (row + colum) == X [其中X为正方形边长-1]
 *              => 表达式只能将对角线交点处元素累计一次,除非特别声明计算两次
 *
 */
public class Solution02 {

    public static void main(String[] args) {
        int[][] arr= {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(diagonalSum(arr));
    }

    public static int diagonalSum(int[][] arr) {
        int sum = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int colum = 0; colum < arr[row].length; colum++) {
                if (row == colum || (row + colum) == 2) {
                    sum += arr[row][colum];
                }
            }
        }
        return sum;
    }
}
