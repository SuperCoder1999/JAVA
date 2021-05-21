package chapter6_array;
/**
 * 有一个数列：白眉鹰王、金毛狮王、紫衫龙王、青翼蝠王猜数游戏：
 * 		从键盘中任意输入一个名称，判断数列中是否包含此名称【顺序查找】
 * 		要求: 如果找到了，就提示找到，并给出下标值
 */

import java.util.Scanner;
public class SeqSearch {
    public static void main(String[] args) {
        String[] name = {"金毛狮王", "放下她", "白眉鹰王", "拜登"};
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter findName: ");
        String findName = myScanner.next();
        // 创建索引
        int index = -1;
        for (int i = 0; i < name.length; i++) {
            if (findName.equals(name[i])) {
                index = i;
                break;
            }
        }
         if (index == -1)
             System.out.print("no find");
         else
             System.out.print("index = " + index);
    }
}
