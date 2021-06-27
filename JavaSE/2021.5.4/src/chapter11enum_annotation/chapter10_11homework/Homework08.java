package chapter11enum_annotation.chapter10_11homework;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Homework08 {
    public static void main(String[] args) {
        Color color = Color.RED;
        switch (color) {
            case RED:
                System.out.println("RED");
                break;
            case BLUE:
                System.out.println("BLUE");
                break;
            case BLACK:
                System.out.println("BLACK");
                break;
            case YELLOW:
                System.out.println("YELLOW");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
        }
    }
}

interface IColor {
    public void show();
}

enum Color implements IColor {
    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private double redValue;
    private double greenValue;
    private double blueValue;

    Color(double redValue, double greenValue, double blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public void show() {
        System.out.println(toString() + " " + redValue + ", " + greenValue + ", " + blueValue);
    }
}