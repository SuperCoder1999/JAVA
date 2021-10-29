package test;

/*
    ArrayList的下标是从0开始的吗
    答案：是从0开始的
 */


import java.util.ArrayList;

public class Test4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(32);
        System.out.println(arrayList.get(2));
    }
}
