package homeworks.h20210921;

import java.util.ArrayList;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {
        int[][] arr = {{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        System.out.println(shiftGrid(arr, 23));
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        /*
        1.如果循环k次，每次需要移动250个数字，就要250^100次方，耗时过长。实例3提示：每9次转换就会恢复原样。
        2.所以只需要循环 k %= 9 次即可
         */
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        for (int i = 0; i < k; i++) {
            int[] right = new int[m];//保存右侧一列
            for (int j = 0; j < m; j++) {
                right[j] = grid[j][n - 1];
            }

            //grid[m - 1][n - 1] = grid[0][0];
//            for (int j = 0; j < m - 1; j++) {
//                grid[j][n -1] = grid[j+1][0];
//            }
            for (int j = 0; j < m; j++) {
                for (int l = n - 2; l >= 0; l--) {
                    grid[j][l + 1] = grid[j][l];
                }
            }
            grid[0][0] = right[m - 1];
            for (int j = 0; j < m - 1; j++) {
                grid[j + 1][0] = right[j];
            }
        }

        List<List<Integer>> integers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> integer = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                integer.add(grid[i][j]);
            }
            integers.add(integer);
        }
        return integers;
    }
}
