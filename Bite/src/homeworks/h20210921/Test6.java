package homeworks.h20210921;

public class Test6 {
    public static void main(String[] args) {
        A<Double> a = new A<>(1.1);
        System.out.println(a.get());
        A<Boolean> b = new A<>(true);
        System.out.println(b.get());
    }
}

class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}