package chapter17thread.thread;

/*
        ------------ 实现Runnable接口来创建线程 -----------
    一：说明
    1. 由于java是单继承机制，在某些情况下一个类可能已经继承了某个父类，这时在用继承Thread类方法来创建线程显然不可能了
    2. java设计者提供给另一种创建线程的方式：通过实现Runnable接口来创建线程

    二：细节
    1. Runnable接口中没有start0方法，需要通过Thread对象来调用 - 即代理模式
 */

public class CreateThreadImplement {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.start(); 这里不能调用start
        //创建了Thread对象，把 dog对象(实现Runnable),放入Thread
        Thread thread = new Thread(dog);
        thread.start();

//        Tiger tiger = new Tiger();//实现了 Runnable
//        ThreadProxy threadProxy = new ThreadProxy(tiger);
//        threadProxy.start();
    }
}
class Dog implements Runnable { //通过实现Runnable接口，开发线程

    int count = 0;

    @Override
    public void run() { //普通方法
        System.out.println("Cat线程名称=" + Thread.currentThread().getName());
        while (true) {
            System.out.println("小狗汪汪叫..hi" + (++count));

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