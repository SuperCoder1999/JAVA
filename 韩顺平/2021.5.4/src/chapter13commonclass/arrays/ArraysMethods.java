package chapter13commonclass.arrays;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
    Arrays中包含了一些列静态方法，用于管理或操作数组（比如排序和搜索）

    一：Arrays类常见方法应用案例：
    1）toString 返回数组的字符串形式
    Arrays.toString(arr);

    2)sort 排序（自然排序【从小到大】和定制排序）
    3）binarySearch 通过二分搜索法进行查找，要求必须排好序
    int index = Arrays.binarySearch(arr, 3);
 */

public class ArraysMethods {
    public static void main(String[] args) {
        Integer[] integers = {1, 20, 90};

    //遍历数组
        /*
        for(int i = 0; i < integers.length; i++) {
           System_.out.println(integers[i]);
        }
         */
        //新方式：直接使用Arrays.toString方法，显示数组
        //可以返回一个字符串
        System.out.println(Arrays.toString(integers));//


    //进行排序
        Integer arr[] = {1, -1, 7, 0, 89};
        /*
        解读

        1. 可以直接使用冒泡排序 , 也可以直接使用Arrays提供的sort方法排序
        2. 因为数组是引用类型，所以通过sort排序后，会直接影响到 实参 arr
        3. sort是重载了的，也可以通过传入一个接口 Comparator 实现定制排序
        4. 调用 定制排序 时，传入两个参数
            (1) 排序的数组 arr
            (2) 实现了Comparator接口的匿名内部类 , 要求实现  compare方法
        5. 先演示效果，再解释
        6. 这里体现了接口编程的方式 , 看看源码，就明白
           源码分析
            (1) Arrays.sort(arr, new Comparator())
            (2) 首先到 Arrays类的 private static <T> void binarySort(T[] a, int lo, int hi, int start,
                                                   Comparator<? super T> c){}
            (3) 再执行到TimSort类中，在该类中执行到binarySort方法会根据动态绑定机制 c.compare()执行传入的
                匿名内部类的 compare ()
                 while (left < right) {
                            int mid = (left + right) >>> 1;
                            if (c.compare(pivot, a[mid]) < 0)
                                right = mid;
                            else
                                left = mid + 1;
                        }
            (4) new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            Integer i1 = (Integer) o1;
                            Integer i2 = (Integer) o2;
                            return i2 - i1;
                        }
                    }
            (5) public int compare(Object o1, Object o2) 返回的值>0 还是 <0
                会影响整个排序结果.

        7. 这个Arrays.sort 方法充分体现了 接口编程+动态绑定+匿名内部类的综合使用
                将来的底层框架和源码的使用方式，会非常常见
         */
        //Arrays.sort(arr); // 默认排序方法，是从小到大排序
        //定制排序
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println("===排序后===");
        System.out.println(Arrays.toString(arr));//

    // binarySearch
        Integer[] arr1 = {1, 2, 90, 123, 567};
        // binarySearch 通过二分搜索法进行查找，要求必须排好
        // 解读
        //1. 使用 binarySearch 二叉查找
        //2. 要求该数组是有序的. 如果该数组是无序的，不能使用binarySearch
        //3. 如果数组中不存在该元素，就返回 return -(low + 1);
                //  key not found. low代表的是所查找数应该在的位置
        int index = Arrays.binarySearch(arr1, 91);
        System.out.println("index=" + index);

    //copyOf 数组元素的复制
        // 老韩解读
        //1. 从 arr1 数组中，拷贝 arr.length个元素到 newArr数组中
        //2. 如果拷贝的长度 > arr1.length 就在新数组的后面 增加 null
        //3. 如果拷贝长度 < 0 就抛出异常NegativeArraySizeException
        //4. 该方法的底层使用的是 System_.arraycopy()
        Integer[] newArr = Arrays.copyOf(arr1, arr1.length);
        System.out.println("==拷贝执行完毕后==");
        System.out.println(Arrays.toString(newArr));

        // 拷贝数组的区间
        // 技巧：出现from-to一般是左闭右开区间：[)
        //int ret2 = Arrays.copyOfRange(arr1, 1, 3); // [1,3)
        //System.out.println(Arrays.toString(rets));

        // 拷贝方法三：arraycopy(arr,0, copy, 0, arr.length);
        int[] arr3 = {1, 2, 3, 4};
        int[] copy = new int[arr3.length];
        System.arraycopy(arr3,0, copy,0,arr3.length);
        //从arr3的下标0开始拷贝，拷贝到copy的0下标开始，拷贝arr3.length长度
        
        // 拷贝方法四：int[] arr6 = arr5.clone();
        int[] arr5 = {1,2,3};
        int[] arr6 = arr5.clone();
        System.out.println(Arrays.toString(arr6));


    //ill 数组元素的填充
        Integer[] num = new Integer[]{9,3,2};
        //解读
        //1. 使用 99 去填充 num数组，可以理解成是替换原理的元素
        Arrays.fill(num, 99);
        System.out.println("==num数组填充后==");
        System.out.println(Arrays.toString(num));

    //equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1, 2, 90, 123};
        //老韩解读
        //1. 如果arr 和 arr2 数组的元素一样，则方法true;
        //2. 如果不是完全一样，就返回 false；如果都是null则返回false
        boolean equals = Arrays.equals(arr1, arr2);
        System.out.println("equals=" + equals);

    //asList 将一组值，转换成list
        //老韩解读
        //1. asList方法，会将 (2,3,4,5,6,1)数据转成一个List集合
        //2. 返回的 asList 编译类型 List(接口)
        //3. asList 运行类型 java.util.Arrays$ArrayList, 是Arrays类的
        //   静态内部类 private static class ArrayList<E> extends AbstractList<E>
        //              implements RandomAccess, java.io.Serializable
        List asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList=" + asList);
        System.out.println("asList的运行类型" + asList.getClass());

    }
}
