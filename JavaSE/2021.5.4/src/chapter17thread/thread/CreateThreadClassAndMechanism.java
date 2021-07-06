package chapter17thread.thread;

/*
    线程机制想要深入学习，需要掌握操作系统机制

    --------------本节介绍继承Thread类的创建方式-------------

    1. 创建线程的方式：一个类继承Thread类、实现Runnable接口
    2. 当一个类继承了Thread类，该类就可以当作是线程使用
    3. 此时，重写run方法，在方法体中写上自己的业务代码
    （Thread类中的run()方法是 实现了Runnable接口中的run方法）

        @Override
        public void run() {
            if (target != null) {
                target.run();
            }
        }

    4. 进程机制讲解：
    1. 当run(执行)程序时，就启动了一个进程。
    2. 启动这个进程之后立刻开启主线程(main线程)
    3. 主线程中，创建了一个子线程，Cat cat = new Cat();并且在cat.start();时启动这个子线程
        1）这个线程名：Thread.currentThread().getName(); -> 即 Thread-0
        2）主线程中创建的该线程不会阻塞主线程的进行。主线程和子线程是交替执行..（实际上是并行状态(不同情况不一样),只是显示窗口只能同时显示一个
        3）主线程的名字默认就是main
    4. 可以使用JConsole 监控线程执行情况
        1）主(main)线程由于执行60s，提前结束，就消失了.而Thread-0还在执行。直到最后一个线程结束，进程才结束。
        【在JConsole中还显示Thread-0是因为由于链接断开，界面卡住了】
        所以说：在多线程编程中，不是主线程结束，进程就结束了。直到最后一个线程结束，进程才结束。
    5. 主线程可以开多个子线程，而子线程也可以再开子线程
    6. start0()方法才是实现多线程的方法，而不是run().又因为start0()是start()方法调用的，所以用cat.start();来启动线程

 */

public class CreateThreadClassAndMechanism {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();//创建Cat对象，可以当做线程使用
        //源码,start()方法调用start0()方法后，该线程不一定会立马执行，只是将线程变成了可执行状态。具体什么时候
        //执行，取决于底层算法。算法根据CPU资源、内存资源、IO资源来决定
        /*
            (1)
            public synchronized void start() {
                start0();
            }
            (2)
            //start0() 是本地方法，是JVM调用, 底层是c/c++实现
            //真正实现多线程的效果， 是start0(), 而不是 run()
            private native void start0();

         */
        cat.start();//启动线程-> 最终会执行cat的run方法
    /*
        如果采用cat.run();的方式开启子线程，其本质就是之前所学的调用方法，
        依旧在执行main线程，且不是同步的（会产生阻塞）。可以称之为：串行化
        所以在System.out.println("Cat线程名称=" + Thread.currentThread().getName());输出的是main。
     */

        //说明: 当main线程启动一个子线程 Thread-0, 主线程不会被阻塞, 会继续执行
        //这时 主线程和子线程是交替执行..
        System.out.println("主线程继续执行" + Thread.currentThread().getName());//主线程的名字默认就是main
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}

//通过继承Thread类来创建线程。
class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        System.out.println("Cat线程名称=" + Thread.currentThread().getName());
        while (true) {
            //该线程每隔1秒。在控制台输出 “喵喵, 我是小猫咪”
            System.out.println("喵喵, 我是小猫咪" + (++times));
            try {
                //让该线程休眠1秒
                Thread.sleep(1000);// 这里会报编译错误，可以throws、try-catch来提前处理
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80)
                break;//当times 到8, 退出while, 这时线程也就退出..
        }
    }
}