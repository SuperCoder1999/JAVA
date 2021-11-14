package question.genetic;

/**
 * 方法泛型中，参数中的 类泛型 是否也能赋值给方法泛型的泛型参数
 * 答案：题目问题就错了。参数中的 类泛型 是实参，目的是定义类泛型的真实类型。所以类泛型只能填 真实的类型
 * 而由于 方法泛型 可以用在方法 中任意位置，所以这里 真实的情况是：方法泛型 在给 类泛型 赋值
 *
 * 关于问题的描述也有一定的道理：方法 泛型的赋值确实是 由 参数列表中的泛型 反推推出 方法泛型的真实类型。所以
 * 类泛型 先确定 之后 反推退出 方法泛型的类型
 */
public class Test<L> {

    public static void main(String[] args) {
        Test test = new Test();
        test.test04();
    }

    public <T> T test01(T a) {
        T t = a;
        return t;
    }

    public <E> E test02(AA<E> aa) {
        return aa.aa_value;
    }

    public void test03(AA<L> bb) { // 这里 L 是 类泛型

    }

    public <I> void test04() {//方法泛型 的 泛型 只能由 参数列表中赋值。没有其他路径
        I a;
    }

    /*public <Y> Y test05() {
        Object object = null;
        Object result = null;

        result = (Y)object;

        return result;
    }*/

    /*public String test05() {
        Object object = null;
        Object result = null;

        //result = (String)object;
        result = "123";

        return result;
    }*/

    public void test06() {

    }
}

class AA<K> {
    K aa_value;
}