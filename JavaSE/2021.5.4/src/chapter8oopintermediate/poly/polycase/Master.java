package chapter8oopintermediate.poly.polycase;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo(Animal animal, Food food) {
        System.out.println("Master：" + name + " 正在给 " + animal.getName() + " 喂 " + food.getName());
    }
}
