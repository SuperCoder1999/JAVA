package question;

/*
    try-catch 会终止循环吗？
    答案：不能终止循环。try-catch只会终止 try中出现异常之后的语句
 */

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            System.out.println("在循环");
            Thread.sleep(500);
            try {
                f1();
                System.out.println("出现异常了");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

    }

    static void f1() throws IllegalAccessException {
        throw new IllegalAccessException("报错");
    }
}
