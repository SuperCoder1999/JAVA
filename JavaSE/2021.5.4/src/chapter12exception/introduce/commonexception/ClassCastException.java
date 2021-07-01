package chapter12exception.introduce.commonexception;

/*
    当试图将对象强制转换为不是实例的子类时，抛出该异常。
 */

public class ClassCastException {
    public static void main(String[] args) {
        A b = new B(); //向上转型
        B b2 = (B)b;//向下转型，这里是OK
        C c2 = (C)b;//这里抛出ClassCastException
    }
}
class A {}
class B extends A {}
class C extends A {}