package chapter15genetic.customgeneric;
import java.util.Arrays;

/*
    一：自定义泛型类
    1.基本语法
    class 类名 <T,R...> {
    }

    二：细节
    1. 普通成员可以使用泛型(属性、方法。实际上属性、局部变量、方法、参数类型（传入的形参）都可以使用到泛型)
    2. 使用泛型的数组，不能初始化，只能声明泛型数组变量
        因为数组在new 不能确定T的类型，就无法在内存开空间
          (这里还是不太清楚：我的假设中：数组开辟空间是在class被new的时候。由于new已经确定了泛型类型，那么为什么还开辟不了空间？）
            错误：T[] ts = new T[5]; 或许因为类加载时会触发new
        T[] ts;正确
    3. 静态成员中不能使用类的泛型。（毕竟，静态方法在没有创建对象时就可以使用）
    4. 泛型E\R代表的类型，就是在创建对象时确定的（因为创建对象时，需要传入确定类型）
    5. 如果在创建对象时，没有指定类型，默认为Object
 */

@SuppressWarnings({"all"})
public class CustomGenericClass {
    public static void main(String[] args) {

        //T=Double, R=String, M=Integer
        // Integer默认值是 null
        Tiger<Double,String,Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是Object子类
        System.out.println("g2=" + g2);

    }
}

//解读
//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.有多少，new时就要传入都多少个
//4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger<T, R, M extends Number> {
    String name;
    R r; //属性使用到泛型
    M m;
    T t;
    //因为数组在new 不能确定T的类型，就无法在内存开空间
    //  (这里还是不太清楚：我的假设中：数组开辟空间是在class被new的时候。由于new已经确定了泛型类型，那么为什么还开辟不了空间？）
    //T[] ts = new T[5];//错误，不能初始化，只能声明泛型数组变量
    T[] ts;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(R r, M m, T t) {//构造器使用泛型

        this.r = r;
        this.m = m;
        this.t = t;
        Number n = m;
    }

    public Tiger(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化
//    static R r2;
//    public static void m1(M m) {
//
//    }

    //方法使用泛型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {//方法使用到泛型
        this.r = r;
    }

    public M getM() {//返回类型可以使用泛型.
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
