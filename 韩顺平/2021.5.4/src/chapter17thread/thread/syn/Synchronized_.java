package chapter17thread.thread.syn;

/*
    -----------------线程同步机制------------
    一：由于窗口售票中，两种线程类都有缺点。此时可以使用 synchronized 关键字来解决.目前只能解决接口线程

    二：线程同步机制
    1. 在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术，保证数据在任何同一时间，
    最多有一个线程访问，以保证数据的完整性。
    2. 线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到
    该线程完成操作，其他线程才能对该内存地址进行操作。

    三：同步具体方法 - synchronized 互斥锁
    1. 同步代码块 - 尽量多用同步代码块
    synchronized (对象) { // 得到对象的锁，才能操作同步代码
        //需要被同步代码；
    }

    2. synchronized 还可以放在方法声明中，表示整个方法为同步方法
    public synchronized void m(String name) {
        // 需要被同步的代码
    }

    四：互斥锁
    1. 基本介绍
        1）Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性
        2）每个对象都对应一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。
        3）关键字synchronized来与对象的互斥锁联系。当某个对象用synchronized修饰时，表明该对象在任一时刻只能
        由一个线程访问。
        4）同步的局限性：导致程序的执行效率降低
        5）同步方法（静态的）的锁为当前类本身
    2.注意事项、细节
     1)同步方法如果没有static修饰，默认锁对象为this - 继承Thread的方法，不能锁this
     2)如果方法使用static修饰，默认锁对象：当前类.class
     3）同步代码块的锁对象，由自己定义，对于接口创建的线程，可以定义为 this，或者在线程中创建对象。
     4）同步代码块的锁对象，对于继承创建的线程，应该使用 当前类.class 的对象（不确定，暂时不研究）
     5）this对象锁时非公平锁 - 可能同一个线程一直在持有this
    3. 实现的步骤：
        1）需要分析上锁的代码
        2）选择同步代码块或同步方法
         - 尽量选择同步代码块（同步代码块的代码量、执行量少，对程序整体的效率降低就减少）
        3）要求多个线程的锁对象为同一个即可

    4. 互斥锁本质分析：
        1）对于同一个对象(即用接口的方式创建线程的方式)的所有线程来说：
            进入线程前需要获得锁对象（锁对象只能同时被一个线程持有)，没有获取的将处于Blocked状态。获得的进入同步代码块，
            同步代码块(同步方法)一旦执行完成锁对象就变成公共的，所有线程来抢夺这个锁对象。获得的线程又可以进入同步代码块进行操作。

            2. 当多个线程执行到同步代码块时，就会去争夺 this对象锁
            3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
            4. 争夺不到this对象锁，就blocked ，准备继续争夺
            5. this对象锁是非公平锁.

        2）对于继承的方式来实现互斥锁的本质暂时不懂

 */

public class Synchronized_ {
    public static void main(String[] args) {
//        SellTicket01 sellTicket0 = new SellTicket01();
//        SellTicket01 sellTicket1 = new SellTicket01();
//        SellTicket01 sellTicket2 = new SellTicket01();
//
//
//        sellTicket0.start();
//        sellTicket1.start();
//        sellTicket2.start();

        SellTicket sellTicket = new SellTicket();
        Thread thread0 = new Thread(sellTicket);
        Thread thread1 = new Thread(sellTicket);
        Thread thread2 = new Thread(sellTicket);

        thread0.start();
        thread1.start();
        thread2.start();

    }
}

class SellTicket extends Thread {
    static int nums = 100;
    private boolean loop = true;
    Object object = new Object();// ---- 因为只创建了一个sellTicket对象，所以object都是同一对象

    // 1. public synchronized void sell() 就是一个同步方法
    // 2. 这时锁在 this对象上
    // 3. 也可以在代码块上写 synchronized ，同步代码块
    // 4. 同步方法（非静态的）的锁可以是this，也可以是其他对象（要求是同一对象即可）

    public /*synchronized*/ void sell() {

        synchronized (/*this*/ object) {
            if (nums <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--nums));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    // 同步方法（静态的）的锁为当前类本身
    // 1. public synchronized static void m1() {} 锁是加在SellTicket.class上的
    public synchronized  static void m1() {
    }

    // 2. 如果在静态方法中，实现一个同步代码块
    /*
        synchronized (SellTicket03.class) { ---- 静态的锁是当前类本身
            System.out.println("m2");
        }
     */
    public static void m2() {
        synchronized (SellTicket.class) {
        }
    }

    @Override
    public void run() {
        while (loop) // ------ while 放在synchronized外面，防止一次性全部执行完了
            sell();
    }
    /*
    public synchronized void run() {  --- 这种同步方式，将导致，第一个线程执行把while循环全部执行完
        while (true) {
            if (nums <= 0) {
                System.out.println(Thread.currentThread().getName() + " " + "售票结束...");
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
     */
}

//使用Thread方式
// new SellTicket01().start()
// new SellTicket01().start();
class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

//    public void m1() {
//        synchronized (this) {
//            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
//                    + " 剩余票数=" + (--ticketNum));
//        }
//    }

    @Override
    public void run() {


        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒, 模拟
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票"
                    + " 剩余票数=" + (--ticketNum));

        }
    }
}