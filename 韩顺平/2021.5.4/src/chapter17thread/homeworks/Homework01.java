package chapter17thread.homeworks;

import java.util.Scanner;

/*
    如果不能在方法中传参，可以考虑在类中添加属性，来传参
 */

public class Homework01 {
    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start();
        Thread02 thread02 = new Thread02(thread01);
        Thread thread = new Thread(thread02);
        thread.start();
    }
}

class Thread01 extends Thread {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(1000); // 如果输出过快，会导致输入的字符串无法录入
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Thread02 implements Runnable {
    private Thread01 t;// 着可以当作方法中的传参来使用
    public Thread02(Thread01 t) {
        this.t = t;
    }
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        char ch = '0';
        while (true) {
            if (scanner.next().charAt(0) == 'Q') {
                t.setLoop(false);
                System.out.println("b线程退出");
                break;
            }
        }
    }
}