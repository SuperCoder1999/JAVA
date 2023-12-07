package chapter10oopsenior.interface_;

/*
    四:
        当一个类实现多个接口时，向上转型可以任意选择一个接口作为编译类型
 */
public class InterfaceExtendsMoreInterface {
    Grand01 g = new Father01();
    Grand02 g2 = new Father01();
}

interface Grand01 {
    void f1();
}

interface Grand02 {
    void f2();
}

class Father01 implements Grand01, Grand02 {
    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }
}