package chapter10oopsenior.interface_.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        new C().pX();
        C c = new C();

        // System.out.println(c.x);
            // 这样调用时也不行
    }
}

interface AA {  // 1min 看看
    int x = 0;
}  //想到 等价 public static final int x = 0;

class BB {
    int x = 1;
} //普通属性

class C extends BB implements AA {
    public void pX() {
        //System.out.println(x); //错误，原因不明确x
        //可以明确的指定x
        //访问接口的 x 就使用 A.x
        //访问父类的 x 就使用 super.x
        System.out.println(AA.x + " " + super.x);
    }
}