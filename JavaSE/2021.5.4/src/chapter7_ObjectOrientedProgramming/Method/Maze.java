package chapter7objectorientedprogrammingprimary.Method;

public class Maze {
    public static void main(String[] args) {
        // 绘制迷宫
        int map[][] = new int[8][7];
        // 左右边框
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 上下边框
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 突出的位置
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        // 检验绘制情况:
        for (int arr[] : map) {
            for (int n : arr)
                System.out.print(n + " ");
            System.out.println();
        }
        // 输出走出迷宫的路径
        Find aFind = new Find();
        aFind.findWay(map, 1, 1);
        System.out.println("---  ---");
        for (int[] arr: map) {
            for (int n : arr)
                System.out.print(n + " ");
            System.out.println();
        }
    }
}

class Find {
    public boolean findWay(int[][] map, int x, int y) {// x 代表层数
        if (map[6][5] == 2)
            return true;
        else {
            if (map[x][y] == 0){
                map[x][y] = 2;
                if (findWay(map, x,y + 1))// 右
                    return true;
                else if (findWay(map, x + 1, y))// 下
                    return true;
                else if (findWay(map, x, y - 1))// 左
                    return true;
                else if (findWay(map, x - 1, y))
                    return true;
                else {
                    map[x][y] = 3;
                    return false;
                }
            }
            else
                return false;
        }
    }
}
