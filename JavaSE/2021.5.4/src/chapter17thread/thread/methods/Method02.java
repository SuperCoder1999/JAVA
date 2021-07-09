package chapter17thread.thread.methods;

/*
    8) yield(是一个静态方法): 线程的礼让。让出CPU，让其他程序(并没有指定让谁先执行，只是让出了自己的顺序)执行，
        但是礼让的时间不确定，所以不一定礼让成功。Thread.yield();//礼让，不一定成功..
    9) join: 线程的插队。插队的线程一旦插队成功，则一定线程完插入的线程所有的任务。
        t2.join();// 这里相当于让t2 线程先执行完毕
 */

public class Method02 {
    public static void main(String[] args) throws InterruptedException {

        T2 t2 = new T2();
        t2.start();

        for(int i = 1; i <= 20; i++) {
            Thread.sleep(500);
            System.out.println("主线程(小弟) 吃了 " + i  + " 包子");
            if(i == 5) {
                System.out.println("主线程(小弟) 让 子线程(老大) 先吃");
                //join, 线程插队
                //t2.join();// 这里相当于让t2 线程先执行完毕
                Thread.yield();//礼让，不一定成功..
                System.out.println("线程(老大) 吃完了 主线程(小弟) 接着吃..");
            }

        }
    }
}
class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(500);//休眠0.5秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程(老大) 吃了 " + i +  " 包子");
        }
    }
}