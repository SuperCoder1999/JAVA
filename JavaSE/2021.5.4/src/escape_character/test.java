package escape_character;

import java.util.function.DoubleFunction;

public class test {
    public static void main(String[] args) {
        System.out.println("聂健学\"Java\"");
        System.out.println("聂健学\'Java\'");
        System.out.println("聂健学\'Java\'");
        // 单引号或许也不会被误解为其他的
        System.out.println("聂健学'Java'");
        // \r 在cmd中执行和idea执行结果不一样
        System.out.printf("聂健他喜欢\r沈思");
    }
}
