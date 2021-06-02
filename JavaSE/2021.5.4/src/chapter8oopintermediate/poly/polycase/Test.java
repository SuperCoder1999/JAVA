package chapter8oopintermediate.poly.polycase;

public class Test {
    public static void main(String[] args) {

        Master jack = new Master("Jack");
        Animal animal = new Dog("大黄");
        Food food = new Bone("大骨头");
        jack.showInfo(animal, food);

        Master tom = new Master("Tom");
        animal = new Cat("小花猫");
        food = new Fish("鱼干");
        tom.showInfo(animal, food);

    }
}
