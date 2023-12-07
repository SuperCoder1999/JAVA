package chapter17thread.thread.methods;

public class MethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Hello hello = new Hello();
        Thread thread = new Thread(hello);

        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + i);
            Thread.sleep(500);
            if (i == 5) {
                System.out.println("优先进行子线程---");
                thread.start();
                thread.join();
                System.out.println("子线程执行结束。。。");
            }
        }
        System.out.println("主线程结束。。。");
    }
}

class Hello implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            if (count >= 20) {
                System.out.println(Thread.currentThread().getName() + "Hello 线程结束~");
                break;
            }
            System.out.println("hello" + (++count));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}