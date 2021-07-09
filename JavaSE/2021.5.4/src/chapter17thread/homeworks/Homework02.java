package chapter17thread.homeworks;

/*
    因为这里涉及到多个线程共享资源，所以我们使用实现Runnable方式
 */

public class Homework02 {
    public static void main(String[] args) {
        Count count = new Count();
        Thread t1 = new Thread(count);
        t1.setName("count1");
        Thread t2 = new Thread(count);
        t2.setName("count2");
        t1.start();
        t2.start();
    }
}

class Count implements Runnable {
    private int left = 10000;
    boolean loop = true;
    @Override
    public void run() {
        while (loop) { // - 休眠的语句可以不用包含在同步代码块
            //解读
            //1. 这里使用 synchronized 实现了线程同步
//            2. 当多个线程执行到这里时，就会去争夺 this对象锁
//            3. 哪个线程争夺到(获取)this对象锁，就执行 synchronized 代码块, 执行完后，会释放this对象锁
//            4. 争夺不到this对象锁，就blocked ，准备继续争夺
//            5. this对象锁是非公平锁.
            synchronized (this) {
                if (left <= 0) {
                    System.out.println("余额不足");
                    break;
                }
                System.out.println("线程"+ Thread.currentThread().getName() + " 余额=" + (left-=1000));
            }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}