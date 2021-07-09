package chapter17thread.thread.createthread;

public class Exercise01 {
    public static void main(String[] args) {
        World world = new World();
        Thread thread = new Thread(world);
        thread.start();


        Hi hi = new Hi();
        Thread thread1 = new Thread(hi);// thread = new Thread(hi); 不知道这样会不会影响之前的线程
        thread1.start();
        // 这里，main线程的子线程会单独留下来执行，main线程中的子线程不算main线程的进度。所以main线程很早就退出了
    }
}

class World implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello World" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count >= 10)
                break;
        }
    }
}

class Hi implements Runnable {
    int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hi线程名称=" + Thread.currentThread().getName() + "hi" + ++count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                if (count >= 10)
                break;
        }
    }
}