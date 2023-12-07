package chapter10oopsenior.static_.staticparameter;

public class StaticIntroduce {
    public static void main(String[] args) {

        //定义一个变量 count, 统计有多少小孩加入了游戏
        int count = 0;

        Child child1 = new Child("白骨精");
        child1.join();
        count++;// 这样导致count没有和Child封装在一起、未来在其他方法中还要调用main方法中的count。
            // （就像前面房屋出租系统中count和House分离。其实可以优化的

        Child child2 = new Child("狐狸精");
        child2.join();
        count++;

        Child child3 = new Child("老鼠精");
        child3.join();
        count++;

    }
}

class Child { //类
    private String name;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + " 加入了游戏..");
    }
}

