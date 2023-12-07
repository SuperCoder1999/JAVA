package chapter17thread.thread.methods;
/*
    1. 线程优先级的范围：
    1) MAX_PRIORITY:10
    2) NORM_PRIORITY:5
    3) MIN_PRIORITY:1

    2. interrupt:中断线程，但并不是真正的结束线程(不是终止线程)。所以一般用于中断正在休眠线程。

    3.
    1）Thread.currentThread().getName() / t.getName()  获取当前线程的名称
    2）t.setName("老韩");/ Thread.currentThread().setName("老韩"); 更改线程名称
    3）t.start(); 启动子线程
    4）run()  调用线程对象的run方法
    5）t.setPriority(Thread.MIN_PRIORITY); / Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        更改线程的优先级
    6) t.getPriority(); / Thread.currentThread().getPriority();获取线程的优先级
    7) interrupt:中断线程，但并不是真正的结束线程(不是终止线程)。所以一般用于中断正在休眠线程。
    8) Thread.sleep() 一个静态方法

 */
public class Method01 {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T t = new T();
        t.setName("老韩");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();//启动子线程


        //主线程打印5 hi ,然后我就中断 子线程的休眠
        for(int i = 0; i < 5; i++) {
            Thread.sleep(1000); // 主方法中的sleep异常可以用throws的方法处理
            System.out.println("hi " + i);
        }

        System.out.println(t.getName() + " 线程的优先级 =" + t.getPriority());//1

        t.interrupt();//当执行到这里，就会中断 t线程的休眠.

    }
}

class T extends Thread { //自定义的线程类
    @Override
    public void run() {
        Thread.currentThread().setName("我");
        while (true) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName() 获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + "  吃包子~~~~" + i);
            }
                try {
                    System.out.println(Thread.currentThread().getName() + " 休眠中~~~");
                    Thread.sleep(20 * 1000);//20秒
                } catch (InterruptedException e) {
                    //当该线程执行到一个interrupt 方法时，就会catch 一个 异常, 可以加入自己的业务代码
                    //InterruptedException 是捕获到一个中断异常.
                    System.out.println(Thread.currentThread().getName() + "被 interrupt了");
                }
        }
    }
}