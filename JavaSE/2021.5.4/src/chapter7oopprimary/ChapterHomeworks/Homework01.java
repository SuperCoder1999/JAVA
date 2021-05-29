package chapter7oopprimary.ChapterHomeworks;

/*
    编写类A01，定义方法max，实现求某个double数组的最大值，并返回
    先完成正常业务，然后再考虑代码健壮性
 */
public class Homework01 {
    public static void main(String[] args) {
        //double[] nums = {1.2, 1.1, 5.5, 0.5, -0.2};
        //double[] nums = {};
        double[] nums = null;

        A01 aA01 = new A01();
        if (aA01.max(nums) != null)
            System.out.println("最大值是： " + aA01.max(nums));
        else
            System.out.println("输入输入有误");
    }
}

class A01 {
    public Double max(double[] nums) {//java中不用传入nums的大小，直接nums.length即可
        // 健壮性1：传入的数组可能长度为0
        // 健壮性2：传入的不是数组，而是地址为null
        if (nums != null && nums.length != 0) {//利用短路与 可以避免执行nums.length
            double max = nums[0];
            for (double i : nums) {//foreach可以不用考虑数组的长度
                if (i > max)
                    max = i;
            }
            return max;
        } else
            return null;
    }
}