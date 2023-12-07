package WinterHomeworks2022.CAndJava.Program.Day05;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/1/12 4:03
 * Description 递归 => 递归过程中累加 => 递归返回时当上本次的值
 * 1.题目: 编写一个递归程序，求一个一维数组的所有元素的和？
 */
public class Solution02 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(getSumByRecursion(nums, nums.length));
    }

    public static int getSumByRecursion(int[] nums, int index) {
        int current = 0;
        if (index == nums.length) {
            current = 0;
        }
        else if (index == 0) {
            current = nums[index];
        }
        else {
            current = nums[index];
        }
        if (index == 0) {
            return current;
        }
        else {
            return getSumByRecursion(nums, index - 1) + current;
        }
    }
}
