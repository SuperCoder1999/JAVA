package WinterHomeworks.day04.choices;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

public class Test1 {
    public static void main(String[] args) {
        Object obj = new Object();
        long i = ObjectSizeCalculator.getObjectSize(obj);
        System.out.println(i);
    }
}
