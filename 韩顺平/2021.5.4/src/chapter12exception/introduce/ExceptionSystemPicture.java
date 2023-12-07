package chapter12exception.introduce;

/*
    一：异常体系图的小结：
    RuntimeException下面的异常都属于运行时异常。
    Exception下面和RuntimeException并列的都属于编译异常

    二：异常处理原则
    1. 运行时异常，编译器检测不出来。一般是由于编程时的逻辑错误，所以程序员应该尽量避免其长生。
    2. 对于运行时异常，可以不作处理，因为这类异常很普遍，若是全部进行处理会对程序的可读性和运行效率有影响
    3. 编译时异常时编译器要求必须处理的异常
 */
public class ExceptionSystemPicture {
    public static void main(String[] args) {
       //Throwable // 通过Ctrl-H查看其下的子类
    }
}
