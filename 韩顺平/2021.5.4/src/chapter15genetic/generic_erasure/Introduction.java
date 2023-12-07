package chapter15genetic.generic_erasure;

import java.util.ArrayList;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/3/30 11:53
 * Description 泛型擦除-观察现象
 * 1.发现获取的都是ArrayList类型,而这个类型等价于ArrayList<Object>
 */
public class Introduction {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();

        System.out.println(intList.getClass().getSimpleName());
        System.out.println(strList.getClass().getSimpleName());

        System.out.println(intList.getClass() == strList.getClass());
    }
}
