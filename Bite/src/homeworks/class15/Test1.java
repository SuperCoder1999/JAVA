package homeworks.class15;
/*
    父类的方法为 private 的时候, 子类方法不能进行重写.
 */
public class Test1 {
    public static void main(String[] args) {

    }
}

class AA {
    private void f1() {
        System.out.println("父类private方法");
    }

    public void f2() {

    }
}

class BB extends AA {
    /*@Override - private方法在子类不能重写
    private void f1() {

    }*/

    @Override
    public void f2() {

    }
}