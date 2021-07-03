package chapter14collection.list_;

/*
    Vector VS ArrayList
                底层结构    版本      线程安全(同步)效率      扩容倍数
    ArrayList   可变数组    JDK1.2      不安全，效率高     如果有参构造器1.5倍；如果无参构造器：第一次默认10，第二次开始1.5倍扩容
    Vector      可变数组    JDK1.0      安全，效率不高     如果无参构造器默认10，满后，按2倍扩容；如果指定大小，每次按2倍扩容
 */

public class VectorVSArrayList {
}
