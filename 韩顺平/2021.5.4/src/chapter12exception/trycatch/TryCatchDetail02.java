package chapter12exception.trycatch;

/*
    四：细节
    5. 如果try代码块有可能有多个异常，可以使用多个catch 分别捕获不同的异常，相应处理。
     要求子类异常写在前面，父类异常写在后面。如果发生异常，只会匹配一个catch。(原因是遇到第一个异常后，try代码块就停止执行了)
 */

public class TryCatchDetail02 {
    public static void main(String[] args) {

        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName());//NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2;//ArithmeticException
        } catch (NullPointerException e) {
            System.out.println("空指针异常=" + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("算术异常=" + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }


    }
}
class Person {
    private String name = "jack";

    public String getName() {
        return name;
    }
}
