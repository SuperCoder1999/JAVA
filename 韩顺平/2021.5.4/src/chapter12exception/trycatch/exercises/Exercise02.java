package chapter12exception.trycatch.exercises;
/**
 * 1.try、catch中有return：先保存return的值，然后执行catch和finally。最后return保存的值。
 * 2.return的优先级：try<catch<finally
 * 3. finally中有return，就执行finally的return
 */
public class Exercise02 {
    public static int method() {
        int i = 1;
        try {
            i++; //i = 2
            String[] names = new String[3];
            if (names[1].equals("tom")) {//空指针
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i; //i = 3
        } finally {//必须执行
            return ++i; //i = 4
        }
    }

    public static void main(String[] args) {
        System.out.println(method());//i = 4
        System.out.println(method2());//i = 2
    }

    public static int method2() {
        int i = 1;
        try {
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;
        } finally {//必须执行
            return ++i; //i = 2
        }
    }
}