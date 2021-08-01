package Classroom.class5array;

/*
    1. 数组的存储形式
    int[] arr1 = {1, 2,3, 4, 5,6}; 存储形式是：arr1是栈中的变量，{}是堆中的，arr1存储{}的地址
    int[] arr2 = new int[10]; 存储形式和arr1相同，且{}每个元素都被初始化为0
    int[] arr3 = new int[]{1,2,3,4} 存储形式和arr1相同

    2. 方法的返回类型可以是数组-int[]

    3. native - 本地方法：是由C/C++编写，在本地方法栈中运行，运行速度很快。

    4. 数组拷贝四种方式
        Integer[] newArr = Arrays.copyOf(arr1, arr1.length);
        int ret2 = Arrays.copyOfRange(arr1, 1, 3); // [1,3)
        System.arraycopy(arr3,0, copy,0,arr3.length);
        int[] arr6 = arr5.clone();
    5. 深拷贝：在堆中重新创建对象，修改其中一个的数据，另一个不会更改。
    浅拷贝：理解不是很清晰。（大体就是能修改另一个版本的数据，注意，单纯的赋值地址可能达不到
    浅拷贝，一定靠看，最终的操作是否对同一个对象进行的）

    6. 二维数组的存储：arr是在栈中的，而arr[0]、arr[1]都在堆中，arr[0]指向的arr[0][i]也在堆中

    7. 二维数组的打印：Arrays.toString(arr)不能使用了，需要用Arrays.deepToString(arr);

    8.Java中不规则二维数组：int[][] arr = new int[2][];必须指定行
    再对每一行进行赋值：arr[0] = new int[2]; arr[1] = new int[3];
    和C语言的差别：C中可以单独指定列，行可以自动推导（C的创建二维数组的操作忘记了，暂时不纠结）
            Java中如果通过指定大小的情况 必须指定行，不能单独指定列。

    2. 关于栈的知识
    堆是整个JVM共享的，而栈每个线程具有一份

 */

import java.util.Arrays;

public class Knowledge {
    public static void main(String[] args) {

        //数组的创建
        int a = 10;
        int b = 20;
        //静态创建数组时，元素可以是变量
        int[] arr1 = {a, b};

        //数组的拷贝
        int[] arr5 = {1,2,3};
        int[] arr6 = arr5.clone();
        System.out.println(Arrays.toString(arr6));


        //二维数组的创建的三种方式(指定大小和初始化只能二选一）
        int[][] array1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] array2 = {{1, 2}, {4, 5, 6}};

        int[][] array3 = new int[][]{{1,2, 3}, {4, 5,6}};

        int[][] array4 = new int[2][3];
        int[][] array5 = new int[2][];

    }
}
