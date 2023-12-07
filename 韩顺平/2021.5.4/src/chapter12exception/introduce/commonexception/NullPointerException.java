package chapter12exception.introduce.commonexception;

/*
    NullPointerException - 空指针异常
    当应用程序试图在需要对象的地方使用 null时，抛出该异常

 */
public class NullPointerException {
    public static void main(String[] args) {

        String name = null;
        System.out.println(name.length());
    }
}
