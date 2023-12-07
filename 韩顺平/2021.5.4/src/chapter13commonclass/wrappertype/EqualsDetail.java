package chapter13commonclass.wrappertype;

/*

    二："=="在不同情况的含义
    1. 只要有基本数据类型，判断的就是值是否相同
    2. 两边都是包装类的情况就是判断是否是同一对象实例

    二：
    1. new的方式一定没有用到缓存对象

    三：
    int和int之间，用==比较，肯定为true。基本数据类型没有equals方法
    int和Integer比较，Integer会自动拆箱，== 和 equals都肯定为true（本质不是Integer拆箱，应该是int装箱后拆箱）
    int和new Integer比较，Integer会自动拆箱，调用intValue方法, 所以 == 和 equals都肯定为true（本质不是Integer拆箱，应该是int装箱后拆箱）
    Integer和Integer比较的时候，由于直接赋值的话会进行自动的装箱。所以当值在[-128,127]中的时候，由于值缓存在IntegerCache中，那么当赋值在这个区间的时候，不会创建新的Integer对象，而是直接从缓存中获取已经创建好的Integer对象。而当大于这个区间的时候，会直接new Integer。
    当Integer和Integer进行==比较的时候，在[-128,127]区间的时候，为true。不在这个区间，则为false
    当Integer和Integer进行equals比较的时候，由于Integer的equals方法进行了重写，比较的是内容，所以为true

    Integer和new Integer ： new Integer会创建对象，存储在堆中。而Integer在[-128,127]中，从缓存中取，否则会new Integer.
    所以 Integer和new Integer 进行==比较的话，肯定为false ; Integer和new Integer 进行equals比较的话，肯定为true

    new Integer和new Integer进行==比较的时候，肯定为false ; 进行equals比较的时候，肯定为true
    原因是new的时候，会在堆中创建对象，分配的地址不同，==比较的是内存地址，所以肯定不同

    装箱过程是通过调用包装器的valueOf方法实现的
    拆箱过程是通过调用包装器的xxxValue方法实现的（xxx表示对应的基本数据类型）

    总结：
    1. Byte、Short、Integer、Long这几个类的valueOf方法实现类似的。所以在[-128,127]区间内，==比较的时候，值总是相等的（指向的是同一对象），在这个区间外是不等的。
    2. 而Float和Double则没有缓存对象
    3. Boolean的值总是相等的（Boolean构造器、装箱的valueOf()方法都是返回缓存对象）
 */
public class EqualsDetail {
    public static void main(String[] args) {
        //示例一
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        System.out.println(i1 == i2);//F
        //示例二
        Integer i3 = new Integer(128);
        Integer i4 = new Integer(128);
        System.out.println(i3 == i4);//F

        //示例三
        Integer i5 = 127;//底层Integer.valueOf(127)
        Integer i6 = 127;//-128~127
        System.out.println(i5 == i6); //T
        //示例四
        Integer i7 = 128;
        Integer i8 = 128;
        System.out.println(i7 == i8);//F
        //示例五
        Integer i9 = 127; //Integer.valueOf(127)
        Integer i10 = new Integer(127);
        System.out.println(i9 == i10);//F

        //示例六
        Integer i11 = 127;
        int i12 = 127;
            //只要有基本数据类型，判断的就是值是否相同
        System.out.println(i11 == i12); //T
        //示例七
        Integer i13 = 128;
        int i14 = 128;
        System.out.println(i13 == i14);//T
    }
}

class Details2 {
    /*
    1. (s==u) ，因为， s 是 Integer 类型， u 是 Long 类型，两个不同类型的引用不能进行 == 比较。
    2. (s==t) ， s 是指向一个 9 的引用，而 t 也是一个指向 9 的引用，虽然都是指向 9 ，但却是指向不同的 9 ，即是两个不同的引用。因此 == 比较返回的是假。
    3. (s.equals(t)) ， Integer 的 equals 方法如下：
        public boolean equals(Object obj) {
            if (obj instanceof Integer) {
                return value == ((Integer)obj).intValue();//这里将obj拆箱
            }
         return false ;
    }

    总结：是 Integer 的实例且 value 值也相等的情况下返回真，其他返回假。
    1. s.equal(t)， s 和 t 都是 Integer 类型且值都为 9 ，因此结果为真。
    2. s.equals(9) , 在进行 equals 比较之前，会对 9 调用 Integer.valueOf 方法，进行自动装箱 ,
    （装箱过程中由于 IntegerCache 中已经存在 9 ，所以，直接返回缓存对象）。 equals 就自然相同了。所以结果为真。
    3. (s.equals( new Integer(9)) ，直接创建了一个新的 Integer 实例，但且值也为 9 ，所以，满足条件，返回真。
     */
    public static void main(String[] args) {
        Integer s=new Integer(9);
        Integer t=new Integer(9);
        Long u=new Long(9);
        System.out.println(s.equals(9));
    }
}
class Details3 {
    /*
    包装类的“==”运算在不遇到算术运算的情况下不会自动拆箱
    包装类的equals()方法不处理数据转型
    摘自《深入理解JAVA虚拟机》

    同类型的进行比较，如Integer 与int，Long与long进行==比较时，会自动拆箱；
    不同类型之间进行比较，如果有一方为非包装类，则会自动拆箱，拆箱后就是比较数值了，不论类型。
    如果两方都为包装类，则不会拆箱，且不能比较，编译会报错
     */
    public static void main(String[] args) {
        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;
        //System.out.println((i == l));//编译会报错
    }
}
