package chapter17thread.thread.createthread;

/*
    ---------- 模拟实现 代理模式  -------------
    1. 这里的start0()方法并不是真正的 Thread.start0() 方法
    而真正的Thread.start0()方法是private，不能外部调用
 */

public class Proxy {
    public static void main(String[] args) throws InterruptedException {

        Tiger tiger = new Tiger();//实现了 Runnable
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
        System.out.println("主线程继续执行" + Thread.currentThread().getName());
        for(int i = 0; i < 60; i++) {
            System.out.println("主线程 i=" + i);
            //让主线程休眠
            Thread.sleep(1000);
        }
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {
    int count = 0;

    @Override
    public void run() {
        System.out.println("Cat线程名称=" + Thread.currentThread().getName());
        while (true) {
            System.out.println("老虎嗷嗷叫...." + (++count));
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}

//线程代理类 , 模拟了一个极简的Thread类
class ThreadProxy implements Runnable {//你可以把Proxy类当做 ThreadProxy

    private Runnable target = null;//属性，类型是 Runnable

    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定（运行类型Tiger）
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start() {
        start0();//这个方法时真正实现多线程方法
    }

    public void start0() {
        run();
    }
}