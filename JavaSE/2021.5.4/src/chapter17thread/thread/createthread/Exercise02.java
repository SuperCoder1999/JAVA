package chapter17thread.thread.createthread;

        /*
            无论哪种方式，都会导致多个线程同时使用同一参数的情况
         */

public class Exercise02 {
    public static void main(String[] args) {
//        SellTicket sellTicket0 = new SellTicket();
//        SellTicket sellTicket1 = new SellTicket();
//        SellTicket sellTicket2 = new SellTicket();
//

//        sellTicket0.start();
//        sellTicket1.start();
//        sellTicket2.start();

        SellTicket01 sellTicket01 = new SellTicket01();
        Thread thread0 = new Thread(sellTicket01);
        Thread thread1 = new Thread(sellTicket01);
        Thread thread2 = new Thread(sellTicket01);

        thread0.start();
        thread1.start();
        thread2.start();

    }
}

class SellTicket extends Thread {
    static int nums = 100;
    @Override
    public void run() {
        while (true) {
            if (nums <= 0) {
                System.out.println("售票结束...");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " " + (--nums));
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class SellTicket01 implements Runnable {
    int nums = 100;
    @Override
    public void run() {
        while (true) {
            if (nums <= 0) {
                System.out.println("售票结束...");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " "+ (--nums));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}