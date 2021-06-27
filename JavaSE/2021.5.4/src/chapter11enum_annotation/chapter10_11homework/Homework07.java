package chapter11enum_annotation.chapter10_11homework;

public class Homework07 {
    public static void main(String[] args) {
        Car07 c1 = new Car07(-19);
        Car07.Air air = c1.new Air();
        air.flow();

        new Car07(29).new Air().flow();

        Car07 c2 = new Car07(44);
        Car07.Air air1 = c2.getAir();
        air1.flow();
    }
}

class Car07 {
    private double temperature;

    public Car07(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public class Air {
        public void flow() {
            if (temperature > 40)
                System.out.println("吹冷风");
            else if (temperature < 0)
                System.out.println("吹热风");
            else
                System.out.println("关闭");
        }
    }

    public Air getAir() {
        return new Air();
    }
}