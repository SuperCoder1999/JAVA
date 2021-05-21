package chapter6_array;
import java.util.Scanner;
public class Array02 {
    public static void main(String[] args) {
        // double[] scores = new double[3];
        double[] scores;
        scores = new double[3];
        Scanner myScanner = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            scores[i] = myScanner.nextDouble();
        }
        for (int i = 0; i < scores.length; i++) {
            System.out.println("The " + (i + 1) + "score = " + scores[i]);
        }

    }
}
