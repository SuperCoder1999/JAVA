package chapter5control.switch_;

import java.util.Scanner;

/**
 * 1. switch分支结构中，对于case的匹配严格按照case书写顺序。非字典序
 * 2. 并且default和case优先级相同,如果default在某些case前,会出现先与这些case与目标匹配,并执行default中的代码
 */
public class SwitchDetails {
    //    使用switch 把小写类型的
    //    char 型转为大写(键盘输入)。只转换a->A, b->B, c, d, e.
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入a-e");
        char c1 = myScanner.next().charAt(0);
        switch (c1) {
            case 'd':
                System.out.println("D");
//                break;
            case 'c':
                System.out.println("C");
//                break;
            case 'b':
                System.out.println("B");
//                break;
            case 'a':
                System.out.println("A");
//                break;
            default:
                System.out.println("你的输入有误~");
                break;
            case 'e':
                System.out.println("E");
//                break;
        }
    }
}