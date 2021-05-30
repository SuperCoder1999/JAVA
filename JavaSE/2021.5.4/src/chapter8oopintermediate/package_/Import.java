package chapter8oopintermediate.package_;

// 注意：import 必须放在所有类之前（在package下面）。可以有多个import且没有顺序要求

// 建议：用到哪个类就导入哪个类，不建议使用 *

import java.util.Scanner; // 表示只引入java.util 包下的Scanner类
//import java.util.*; // 表示将java.util 包下的所有类都引入

import java.util.Arrays;

public class Import {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        // int n = myScanner.nextInt();

        ImportExercise importExercise = new ImportExercise();
        importExercise.sort();

    }
}


class ImportExercise {
    public void sort() {
        // 使用 Arrays 类中的方法 完成 数组排序
        int[] arr = {1, 12, -10, 89, -89};

        Arrays.sort(arr);// 为什么Arrays不用创建对象

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
