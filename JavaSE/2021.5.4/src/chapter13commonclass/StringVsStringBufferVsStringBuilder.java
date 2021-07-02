package chapter13commonclass;

/*
    总结：String、StringBuffer、StringBuilder 比较
    1. StringBuffer和StringBuilder非常类似，均代表可变的字符序列，并且方法也一样【都继承了AbstractStringBuilder类】
    2. String：不可变字符序列，效率低，但是复用率高
      String的复用性更高，原因是：String对象value指向的常量池中的字符串可以被其他的String对象引用。
      而StringBuffer\StringBuilder都是每个对象单独在堆中创建的字符串对象
      同样，String中的各种方法最终都是返回了一个String对象。保证修改前后对象类型不变
    3. StringBuffer：可变字符序列、效率较高(增删方面)、线程安全
    4. StringBuilder：可变字符序列、效率最高、线程不安全
    5. String使用说明：
        String s = "a";
        s += "b";
          实际上原来的“a"字符串对象实例已经闲置了(而是创建了一个新的String对象实例赋给s)，而是产生了一个
        字符串 s+"b" (在常量池中即"ab")。如果多次执行这些改变字符串内容的操作，会导致大量副本字符串
        对象保留在内存中，降低效率。如果这样的操作放在循环中，会极大影响程序的性能
            -》 结论：如果对String做大量修改，不要使用String
    6. 效率比较：
    StringBuilder > StringBuffer > String

    7. 使用原则：
        1）如果字符串存在大量的修改操作，一般使用 StringBuffer或StringBuilder
        2）如果字符串存在大量的修改操作，并在单线程的情况，使用StringBuilder
        3）如果字符串存在大量的修改操作，并在双线程的情况，使用StringBuffer
        4）如果字符串存在大量的修改操作，被多个String对象引用，使用String，比如配置信息等
 */

public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {

        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//StringBuffer 拼接 20000次
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));





        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//StringBuilder 拼接 20000次
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));


        String text = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//String 拼接 20000
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }
}