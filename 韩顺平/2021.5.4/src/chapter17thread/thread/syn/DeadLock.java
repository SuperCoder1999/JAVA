package chapter17thread.thread.syn;

/*
    --------- 线程的死锁 -----------
    一：基本介绍
    1. 多个线程都占用了对方的锁资源，但不肯想让，导致死锁，在编程中一定要避免。
 */

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        // Thread.sleep(1000); 如果两个线程的启动时间有间隔，A线程执行前，o2并没有在B线程中
        B.start();
        // 如果两个线程同时启动，则每一个线程各持有一个对象互斥锁，由于都缺少一个，所以各自的线程都无法结束。
    }
}

//线程
class DeadLockDemo extends Thread {
    static Object o1 = new Object();// 保证多线程，共享一个对象,这里使用static
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDemo(boolean flag) {//构造器
        this.flag = flag;
    }

    @Override
    public void run() {

        //下面业务逻辑的分析
        //1. 如果flag 为 T, 线程A 就会先得到/持有 o1 对象锁, 然后尝试去获取 o2 对象锁
        //2. 如果线程A 得不到 o2 对象锁，就会Blocked
        //3. 如果flag 为 F, 线程B 就会先得到/持有 o2 对象锁, 然后尝试去获取 o1 对象锁
        //4. 如果线程B 得不到 o1 对象锁，就会Blocked
        if (flag) {
            synchronized (o1) {
                //o1是对象互斥锁, 下面就是同步代码 - 一个线程执行前需要持有这个对象(互斥锁)。此时，o1被
                //A线程持有。
                System.out.println(Thread.currentThread().getName() + " 进入1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入2");
                }

            }
        } else {
            synchronized (o2) {
                // o2是对象互斥锁，一个线程执行前需要持有这个对象(互斥锁)。此时，o2被
                // B线程持有。
                System.out.println(Thread.currentThread().getName() + " 进入3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4");
                }
            }
        }
    }
}
