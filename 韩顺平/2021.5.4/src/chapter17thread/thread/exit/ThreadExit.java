package chapter17thread.thread.exit;

/*
    -----------线程终止---------
    一：基本介绍
    1. 当线程完成任务后，会自动退出
    2. 还可以通过使用变量来控制run()方法退出的方式终止线程，即 通知方式
    3. 启动一个线程，在main线程中去停止线程
 */

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t1 = new T();
        t1.start();

        //如果希望main线程去控制t1 线程的终止, 必须可以修改 loop
        //让t1 退出run方法，从而终止 t1线程 -> 通知方式

        //让主线程休眠 10 秒，再通知 t1线程退出
        System.out.println("main线程休眠10s...");
        Thread.sleep(10 * 1000);// 这种写法很清晰
        t1.setLoop(false);
    }
}

class T extends Thread {
    private int count = 0;
    //设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);// 让当前线程休眠50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T 运行中...." + (++count));
        }

    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}