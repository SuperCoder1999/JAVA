package chapter17thread.bite;

import java.util.concurrent.PriorityBlockingQueue;

/**
 *  Thread.interrupted() 与 Thread.currentThread().isInterrupted()方法 的区别
 */

public class IsInterruptedTest {
    public static void main(String[] args) {
        test1();
        System.out.println("===================");
        //test2();
    }

    public static void test1() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("报错");
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + Thread.interrupted());
                }
            }
        };

        thread.start();
        System.out.println("interrupt()之前" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("interrupt()之后" + thread.isInterrupted());
    }

    public static void test2() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                /*try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("报错");
                    e.printStackTrace();
                }*/
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + Thread.currentThread().isInterrupted());
                }
            }
        };

        thread.start();
        System.out.println("interrupt()之前" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("interrupt()之后" + thread.isInterrupted());
    }
}
