package chapter17thread.thread.state;

/*
    一：线程状态。线程可以处于下列状态之一：
    NEW
    至今尚未启动的线程处于这种状态。
    RUNNABLE ------ Runnable 状态是Ready和Running状态的总称
    正在 Java 虚拟机中执行的线程处于这种状态。
    BLOCKED
    受阻塞并等待某个监视器锁的线程处于这种状态。
    WAITING
    无限期地等待另一个线程来执行某一特定操作的线程处于这种状态。
    TIMED_WAITING - Thread.sleep() 时会进入的状态
    等待 另一个线程来执行一个取决于指定等待时间的操作 的线程处于这种状态。
    TERMINATED
    已退出的线程处于这种状态。

    二：Typora 笔记中记录了状态转换图

    三：查看状态 - t.getState() / Thread.currentThread.getState() 

 */

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        System.out.println(t.getName() + " 状态 " + t.getState());
        t.start();

        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println(t.getName() + " 状态 " + t.getState());
            Thread.sleep(500);
        }

        System.out.println(t.getName() + " 状态 " + t.getState());

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("hi " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}