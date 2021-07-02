package chapter8oopintermediate.poly;

public class PolyDetail03 {
    public static void main(String[] args) {
        /*
        三：细节三
        1. （属性没有重写之说，这句话，有待确定）属性的值看编译类型(主要因为属性的在编译时就已经决定好的）
          这一点不好解释，结论如下示例：属性的运行类型就是编译类型（父类类型）。如果想用到父类类型，可以间接使用方法
        2.instanceof比较操作符，用于判断对象的运行类型是否为XX类或XX类型的子类型
         */

        // 1.属性的运行类型就是编译类型（父类类型）。
        A a = new B();
        System.out.println(a.n1);

        // 2.instanceOF比较操作符，用于判断对象的运行类型是否为XX类或XX类型的子类型
        A a1 = new B();
        System.out.println(a1 instanceof B);//a1 的运行类型是B类型
        System.out.println(a1 instanceof A);//a1 的运行类型是A的子类型

        String str = "Jack";
        System.out.println(str instanceof Object);//str 的运行类型是Object的子类型
        System.out.println(str instanceof String);//str 的运行类型是String类型

        //System_.out.println(str instanceof B);// str 和 B 没有继承关系，所以不能比较（提示说：不能将str强制转换为B）
    }
}

class A {
    public int n1 = 100;
}

class B extends A {
    public int n1 = 200;
}
