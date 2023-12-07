package chapter6array.create_array;

import java.util.Scanner;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/22 15:57
 * Description
 */
public class CreateArrayWay01 {
    public static void main(String[] args) {
        // 方式一: 动态初始化,直接创建
        // double[] scores = new double[3];
        // 方式二: 动态初始化,先声明在创建
        double[] scores;
        scores = new double[3];
        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            scores[i] = myScanner.nextDouble();
        }
        for (int i = 0; i < scores.length; i++) {
            System.out.println("The " + (i + 1) + "score = " + scores[i]);
        }
    }

    public static void test02() {
        //方式三: 数组静态初始化
        int[] nums = {1,2,3};
        //方式四: 动态静态结合
        int[] nums02 = new int[]{1, 2, 6};
    }
}
