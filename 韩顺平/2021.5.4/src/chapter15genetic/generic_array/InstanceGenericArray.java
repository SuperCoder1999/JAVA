package chapter15genetic.generic_array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/30 15:26
 * Description 实例化 泛型数组
 * 1.只能通过反射的方式 实例化泛型数组
 */
public class InstanceGenericArray {
    public static void main(String[] args) {
        Fruit<String> fruit = new Fruit<>(String.class,3);
        fruit.put(0,"苹果");
        fruit.put(1,"西瓜");
        fruit.put(2,"香蕉");

        System.out.println(Arrays.toString(fruit.getArray()));
        String s1 = fruit.get(2);
        System.out.println(s1);
    }
}

class Fruit<T> {
    private T[] array;

    public Fruit(Class<T> clz, int length){
        //通过Array.newInstance创建泛型数组
        array = (T[]) Array.newInstance(clz, length);
    }

    /**
     * 填充数组
     */
    public void put(int index, T item) {
        array[index] = item;
    }

    /**
     * 获取数组元素
     */
    public T get(int index) {
        return array[index];
    }

    public T[] getArray() {
        return array;
    }
}