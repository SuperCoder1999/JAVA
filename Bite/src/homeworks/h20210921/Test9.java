package homeworks.h20210921;
/*
1013. 将数组分成和相等的三个部分 - https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 */

/* -- 错误算法：左右移动是没有关系的。
public class Test9 {
    public boolean canThreePartsEqualSum(int[] arr) {
//        1.从前往后相加，从后往前相加，遇到前后和相等的情况停止。
//        2.停止后判断，中间剩余的元素和与前部分的和是否相同。不同时，前后继续像中间移动，重复第一步。
//        3.前后指针指向同一元素时，判断结束。

        int left = 0;
        int right = arr.length - 1;
        int lSum = 0;
        int rSum = 0;//前后已经加入的元素的和。避免重复遍历。
        //中间元素的和可以用总和 - lSum - rSum
        int mSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        while (left < right) {
            lSum += arr[left];
            rSum += arr[right];
            if (lSum == rSum) {
                if (sum - lSum - rSum == lSum) {
                    return true;
                }
            } else {
                right--;
                left++;
            }
        }
        return false;
    }
}*/


public class Test9 {
    public boolean canThreePartsEqualSum(int[] arr) {
        /*
        1.判断数组和能否被3整除，能则可以被分割为三份。
        2.当可以被3整除后，先从前面相加，得到 1/3总和时，再从后面相加得到1/3总和。
        3.判断前后指针差是否大于1
         */
        int sum = 0;
        int left = 0;
        int right = arr.length - 1;
        int lSum = 0;
        int rSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0)
            return false;
        while (left < arr.length) {
            lSum += arr[left];
            if (lSum == sum / 3)
                break;
            else
                left++;
        }
        while (right >= 0) {
            rSum += arr[right];
            if (rSum == sum / 3)
                break;
            else
                right--;
        }
        if (right - left > 1)
            return true;
        else
            return false;
    }
}