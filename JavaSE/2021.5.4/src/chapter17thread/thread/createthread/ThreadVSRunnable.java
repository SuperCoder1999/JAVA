package chapter17thread.thread.createthread;

/*
    1.从Java设计来看，通过继承Thread或者实现Runnable接口来创建线程本质上没有区别，从jdk帮助文档可以看到Thread本身就是
    实现了Runnable接口
    2. 实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制。（建议用Runnable创建线程）
     1)共享的意思从Exercise02 中可以看到，接口的方式由于只创建的一个对象，运行的对象其实是同一个。
     而继承的方式由于创建了多个对象，所以运行的是不同的对象
     2）目前能确定的是创建多个同一个线程，运行这些线程实际上只运行一个线程。（为什么会这样，暂且不清楚）
     3）运行后一个疑问：Thread-2不知道为什么没有
     4)另外一个异常情况：就是输出等情况并不是循环的顺序，可能有颠倒的情况




 */


public class ThreadVSRunnable {
    public static void main(String[] args) {
        Hi hi = new Hi();
        Hi hi1 = new Hi();
        Thread thread01 = new Thread(hi);
        Thread thread02 = new Thread(hi);
        Thread thread05 = new Thread(hi1);

        thread01.start();
        thread02.start();

        Cat cat = new Cat();
        Thread thread03 = new Thread(cat);
        Thread thread04 = new Thread(cat);

        thread03.start();
        thread04.start();
    }
}
