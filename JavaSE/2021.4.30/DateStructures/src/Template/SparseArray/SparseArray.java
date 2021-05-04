package Template.SparseArray;

/**
 * 1. 创建一个11*11 的数组
 * 2. 添加几个非零元素
 * 3. 将11*11 的数组存入离散数组中
 * 4. 将离散数组再以11*11 的数组形式输出
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个11*11 的数组
        int[][] chessArray = new int[11][11];
        // 添加非零元素
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        // 输出原数组
        System.out.println("-----原数组-----");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d  ", data);
            }
            System.out.println();
        }
        // 判断原数组中非零元素个数
        int sum = 0;
        for (int[] row : chessArray) {
            for (int data : row) {
                if (data != 0)
                    sum++;
            }
        }
        // 创建离散数组
        int[][] sparseArray = new int[sum + 1][3];
        // 对离散数组赋值
        int count = 0;
        sparseArray[count][0] = 11;
        sparseArray[count][1] = 11;
        sparseArray[count][2] = sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++)
                if (chessArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
        }
        // 输出离散数组
        System.out.println("--- 离散数组 --- ");
        for(int[] row : sparseArray){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
//        for (int i = 0; i < sparseArray.length; i++){
//            System.out.println(sparseArray[i][0]+"  "+sparseArray[i][1]+"  "+sparseArray[i][2]);
//        }
        // 将离散数组以11*11 的数组形式输出
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= sparseArray[0][2]; i++){
            chessArray2[sparseArray[i][1]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("--- 离散数组还原原数组 ---");
        for (int[] row : chessArray2){
            for(int data : row){
                System.out.printf("%d  ",data);
            }
            System.out.println();
        }
    }
}
