package chapter12exception.trycatch.exercises;

/**
 * 1.try、catch中有return：先保存return的值，然后执行catch和finally。最后return保存的值。
 * 2.return的优先级：try<catch<finally
 * 3. finally中有return，就执行finally的return
 */
public class Exercise01 {
    public static int method() {
        try {
            String[] names = new String[3];//String[]数组 数组初始化时每一个元素都是null
            if (names[1].equals("tom")) {//NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {//捕获
            return 3;
        } finally { //必须执行
            return 4; //返回4
        }
    }

    public static void main(String[] args) {
        System.out.println(method()); //4
        System.out.println(method2()); //4
    }

    public static int method2() {
        try {
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {//捕获
            return 3;
        } finally { //必须执行
            return 4; //返回4
        }
    }
}
