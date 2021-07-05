package chapter15genetic.customgeneric;

/*
    一:自定义泛型接口
    1. 基本语法
    interface 接口名 <T,R...> {
    }

    二：注意
    1. 接口中，静态成员也不能使用泛型（这个和泛型类规则一样）
    2. 泛型接口的类型, 在继承接口或者实现接口时确定（其实这里在说怎么给接口类型传参）
        方式一：class BB implements IUsb<Integer, Float> {}
        方式二：interface IA extends IUsb<String, Double> {}。此时实现IA的类，不用再传参

    3. 没有指定类型，默认为Object，但是建议直接写成 IUsb<Object,Object>

    4. 有个疑问：如果声明接口泛型：interface IUsb<U, R>。那么怎么在main中传入类型？
 */

public class CustomGenericInterface {
    public static void main(String[] args) {
    }
}

interface IUsb<U, R> {

    int n = 10;
    //U name; 不能这样使用。接口中的属性,是 public static final（public、static、final可以省略）

    //普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk8 中，可以在接口中，使用默认方法, 也是可以使用泛型
    default R method(U u) {
        return null;
    }
}
//在继承接口 传入 泛型接口的类型
interface IA extends IUsb<String, Double> {

}

//当我们去实现IA接口时，因为IA在继承IUsu 接口时并且指定了U 为String R为Double
//，在实现IUsu接口的方法时，自动使用String替换U, 是Double替换R
class AA implements IA {

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}


//实现接口时，直接传入 泛型接口的类型
//给U 指定Integer 给 R 指定了 Float
//所以，当我们实现IUsb方法时，会使用Integer替换U, 使用Float替换R
class BB implements IUsb<Integer, Float> {

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}

class DD extends BB {
}// 接口中 实现接口的类作为 父类，其子类不用再实现接口中的抽象类

//没有指定类型，默认为Object
//建议直接写成 IUsb<Object,Object>
class CC implements IUsb { //等价 class CC implements IUsb<Object,Object> {
    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {
    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }

}

