package chapter8oopintermediate.homeworks;

public class Homework09 {
    public static void main(String[] args) {
        System.out.println(new LabeledPoint("Blank", 109, 193));
    }
}

class Point {
    private double x = 0;
    private double y = 0;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
                return "LabeledPoint{" +"'" + this.label + "' " +
                        super.getX() + ", " + super.getY() + "}";
    }

//    @Override
//    public String toString() {
//        return "LabeledPoint{" +
//                "label='" + label + '\'' +
//                '}';
//    }
}
