package chapter15genetic.customgeneric;
import java.util.ArrayList;

/*
    一： 自定义泛型方法
    1. 基本语法
    修饰符 <T,R...> 返回类型 方法名(参数列表) {}

    二.注意细节
    1. 泛型方法，可以定义在普通类中，也可以定义在泛型类中
    （当定义在泛型中时，泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型；
    public<K> void hello(R r, K k) { // R 使用的是类声明的泛型，K是来自泛型方法）
    2. 泛型方法调用时，类型就确定了：
    （car.fly("宝马", 100);//当调用方法时，传入参数，编译器就会确定类型。此时T ，R 就被赋值了）
    3. 泛型方法中的 <T,R> 就是泛型  泛型方法被调用后就确定了，这些可以提供给 fly使用的 或者给局部变量等 方法内部成员使用
    3.public void hi(T t) {} 不是泛型方法，因为public 后面没有<> 标识符。这里 hi方法使用了类声明的 泛型 而已

    疑问：泛型方法有什么作用?泛型类的作用也是不太掌握。

 */

@SuppressWarnings({"all"})
public class CustomGenericMethod {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马", 100);//当调用方法时，传入参数，编译器就会确定类型。此时T ，R 就被赋值了
        System.out.println("=======");
        car.fly(300, 100.1);//当调用方法时，传入参数，编译器就会确定类型。此时T ，R 就被赋值了

        //测试
        //T->String, R-> ArrayList
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(), 11.3f);
    }
}

//泛型方法，可以定义在普通类中, 也可以定义在泛型类中
class Car {//普通类
    public void run() {//普通方法
    }
    //说明 普通类中的 泛型方法
    //1. <T,R> 就是泛型  是提供给 fly使用的。或者给局部变量等 方法内部成员使用
    public <T, R> void fly(T t, R r) {//泛型方法
        T t1;
        System.out.println(t.getClass());//String
        System.out.println(r.getClass());//Integer
    }
}

class Fish<T, R> {//泛型类
    public void run() {//普通方法
    }
    public<U,M> void eat(U u, M m) {//泛型方法

    }
    //说明
    //1. 下面hi方法不是泛型方法，因为public 后面没有<> 标识符
    //2. 这里 hi方法使用了类声明的 泛型 而已
    public void hi(T t) {
    }
    //泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型
    public<K> void hello(R r, K k) { // R 使用的是类声明的泛型，K是来自泛型方法
        System.out.println(r.getClass());//ArrayList
        System.out.println(k.getClass());//Float
    }

}