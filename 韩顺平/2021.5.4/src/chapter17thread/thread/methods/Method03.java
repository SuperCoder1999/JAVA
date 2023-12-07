package chapter17thread.thread.methods;

/*
    一：用户线程:也叫工作线程，当线程的任务执行完或通知方式结束
    二：守护线程：一般为工作线程服务的，当所有的用户线程结束，守护线程自动结束
    1.常见的守护线程：垃圾回收机制
    2.如何自己创建一个守护线程：
     myDaemonThread.setDaemon(true);
     注意：这里需要先设置为守护线程后再启动该线程

 */

public class Method03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望当main线程结束后，子线程自动结束
        //,只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();

        for( int i = 1; i <= 10; i++) {//main线程
            System.out.println("宝强在辛苦的工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    public void run() {
        for (; ; ) {//无限循环
            try {
                Thread.sleep(1000);//休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("马蓉和宋喆快乐聊天，哈哈哈~~~");
        }
    }
}