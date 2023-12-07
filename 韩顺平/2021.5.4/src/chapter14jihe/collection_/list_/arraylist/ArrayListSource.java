package chapter14jihe.collection_.list_.arraylist;
import java.util.ArrayList;

/*
    底层代码结论
    1. ArrayList中维护了Object类型的数组elementData：transient Object[] elementData;
     其中transient表示瞬间、短暂的。被该关键字修饰的属性 表示：该示例对象被序列化时该属性不会被序列化
    2. 当创建ArrayList对象时，如果使用的是无参构造器，则初始elementData容量为0，
    第1次添加，则扩容elementData为10，
    如需要再次扩容，则扩容elementData为1.5倍。
    3. 如果使用的是指定大小的构造器，则初始化elementData容量为指定大小，如果需要扩容，则直接
    扩容elementData为当前的1.5倍。
    4.MAX_ARRAY_SIZE是为了给JVM预留头文字,否则报错OOM

    source:
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
            // overflow-conscious code
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);//1.5倍的由来
            if (newCapacity - minCapacity < 0)//判断newCapacity是否大于oldCapacity
            newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)//判断newCapacity是否小于最大容量
            newCapacity = hugeCapacity(minCapacity);
            // minCapacity is usually close to size, so this is a win:
            elementData = Arrays.copyOf(elementData, newCapacity);
            }
 */

@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {

        //老韩解读源码
        //注意，注意，注意，Idea 默认情况下，Debug 显示的数据是简化后的，如果希望看到完整的数据
        //需要做设置.
        //使用无参构造器创建ArrayList对象
        //ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        //使用for给list集合添加 1-10数据
        for (int i = 1; i <= 10; i++) {
            list.add(i);// 将数字进行装箱
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}