package chapter12exception;

/*
    自定义一个异常

    1. 一般情况下，我们自定义异常是继承 RuntimeException
    2. 即把自定义异常做成 运行时异常，好处是可以使用默认的处理机制，比较方便
    （如果定义为编译异常或者是它们的父类Exception，则在调用者处也要throws）
    3. 如果希望抛出异常后继续执行，需要将异常代码包裹try - catch（这里的if()也可以看作 异常代码）
    这样，程序就可以继续执行。---本质就是：throws 并没有处理异常，只是抛出了而已
    4. throw之后的代码不会执行。在编译器中就报错了，除非使用catch获取异常
    因此大多情况下，都是用if 来进行 throw 的
 */

public class CustomException {
    public static void main(String[] args) /*throws AgeException*/ {

        int age = 200;
        //要求范围在 18 – 120 之间，否则抛出一个自定义异常
        //try {
            if (!(age >= 18 && age <= 120)) {
                //这里我们可以通过构造器，设置信息
                throw new AgeException("年龄需要在 18~120之间");
            }
       // } catch (Exception e) {
           // System.out.println(e.getMessage());
       // }
        System.out.println("程序继续");
    }
}

//自定义一个异常
//解读
//1. 一般情况下，我们自定义异常是继承 RuntimeException
//2. 即把自定义异常做成 运行时异常，好处时，我们可以使用默认的处理机制
//3. 即比较方便
class AgeException extends RuntimeException {
    public AgeException(String message) {//构造器
        super(message);
    }
}
