package question.genetic;

import java.util.ArrayList;

/**
 * 关于 泛型 强制转型 的问题：
 * 答案：目前没有发现 泛型会自动进行强制转型。arrayList底层也是靠强转
 */

public class Test2 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Cat());
        //Cat cat = arrayList.get(1);


        ArrayList<Cat> arrayList2 = new ArrayList<Cat>();
        arrayList2.add(new Cat());
        Cat cat2 = arrayList2.get(1);

    }
}

class Cat {
    String name = "111";

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}