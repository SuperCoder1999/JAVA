package chapter12exception.trycatch.exercises;

/*
    知识点：return 时 保存临时变量
 */
/**
 * 1.try、catch中有return：先保存return的值，然后执行catch和finally。最后return保存的值。
 * 2.return的优先级：try<catch<finally
 * 3. finally中有return，就执行finally的return
 */
public class Exercise03 {
    public static int method() {
        int i = 1;//i = 1
        try {
            i++;// i=2
            String[] names = new String[3];
            if (names[1].equals("tom")) { //空指针
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;  // i = 3 => 保存临时变量 temp = 3; 等待finally执行完毕，返回temp值
        } finally {
            ++i; //i = 4
            System.out.println("i=" + i);// i = 4
        }
    }

    public static void main(String[] args) {
        System.out.println(method());// 3
        System.out.println(method2());// 3
    }

    public static int method2() {
        int i = 1;//i = 1
        try {
            i++;// i=2
            String[] names = new String[3];
            if (names[1].equals("tom")) { //空指针
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;  // i = 3 => 保存临时变量 temp = 3; 等待finally执行完毕，返回temp值
        } finally {
            ++i; //i = 4
            System.out.println("i=" + i);// i = 4
        }
    }
}