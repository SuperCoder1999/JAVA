package chapter1openning.compile_question;

/*
    一个 java源文件中有多个main会怎样：
    答案：1.main一定在不同的class类中，Java文件编译后，每个类都会生成 .class文件。
    通过 java Test02 或者 java A  进入相应main入口。也不会导致main入口冲突
 */

public class Test02 {
    public static void main(String[] args) {
        System.out.println("main1");
    }
}

class A {
    public static void main(String[] args) {
        System.out.println("main2");
    }
}

class B {
    public void testB() {
        System.out.println("没有main方法");
    }
}
