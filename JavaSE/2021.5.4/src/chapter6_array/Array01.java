package chapter6_array;

public class Array01 {
    public static void main(String[] args) {
        double[] hens = {3 , 5 , 1};
        double totalWeight = 0;
        for (int i = 0; i < hens.length; i++){
            System.out.println("The " + (i+1) + " hen= " + hens[i]);
            totalWeight += hens[i];
        }
        System.out.println(totalWeight);
    }
}
