package chapter8oopintermediate.object;
/*
    当某个对象没有任何调用时，jvm就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁对象之前，系统
    自动调用finalize方法。子类可以重写该方法，做一些释放资源（原本的数据库链接、打开的文件）的操作。垃圾回收机制的调用，
    是由系统来决定（即由自己的GC算法），也可以通过System.gc()主动给除法垃圾回收机制。
 */
public class Finalize {
    public static void main(String[] args) {
        AAA aaa = new AAA();
        aaa = null;
        System.gc();
        System.out.println("程序退出");
    }
}

class AAA{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收机制触发");
        System.out.println("释放资源：数据库链接、打开文件");
    }
}