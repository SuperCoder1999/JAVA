package chapter2summary.escape_character;

public class Test {
    public static void main(String[] args) {
        // \t：一个制表位，实现对齐功能
        System.out.println
                ("---\\t：一个制表位，实现对齐功能---");
        System.out.println("天津有\t上海4321234\t北京");
        System.out.println("天津有地铁\t上海\t北京五条地铁");
            // idea 中\t很奇怪
        // \n：换行符
        System.out.println("\n---\\n：换行符---");
        System.out.println("jack\nsmith\nmary");
        // \\：一个 \
        System.out.println("\n---\\\\：一个 \\---");
        System.out.println("c:\\Windows");
        // \"：一个 “
        System.out.println("\n---\\\"：一个 \"---");
        System.out.println("聂健学\"Java\"");
            // 这种情况System.out.println("\n---\\\"：一个 “"---");
            //      右边的引号需要 \" -- println("\n---\\\"：一个 “\"---");
            //      左边引号不用 转义(\)
        // \'：一个 '
        System.out.println("\n---\\'：一个 '---");
        System.out.println("聂健学\'Java\'");
        System.out.println("聂健学'Java'");
            // 单引号或许也不会被误解为其他的
        // \r：一个回车(回车不同于换行)
        System.out.println("\n---\\r：一个回车(回车不同于换行)---");
        System.out.printf("聂健他喜欢\r吃饭");
            // \r 在cmd中和idea执行结果不一样
        System.out.printf("聂健他喜欢\r\n吃饭");
            // 这个形式和cmd执行结果一样
    }
}
