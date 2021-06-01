package chapter8oopintermediate.extend.extendexercise;

public class ExtendExercise01 {
    public static void main(String[] args) {
        B02 b = new B02();//会输出什么？
        /*
            a
            b name
            b
         */
    }
}
class A {
    A() {
        System.out.println("a"); // 3
    }

    A(String name) {
        System.out.println("a name");
    }
}

class B extends A {
    B() {
        this("abc"); // 1
        // 这里没有 super();
        System.out.println("b"); // 5
    }

    B(String name) {
        // super(); 被隐藏 // 2  ---------- 注意
        System.out.println("b name"); // 4
    }
}