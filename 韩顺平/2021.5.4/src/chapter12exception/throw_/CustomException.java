package chapter12exception.throw_;

/*
  一: throw的作用
    1. throw 是抛出异常,但是并没有直接抛给调用者方法.可以理解为引爆异常
    2. throw还能抛出try-catch中catch捕获的异常,相当于try-catch白捕获了.

  二:自定义一个异常
    1. 一般情况下，我们自定义异常是继承 RuntimeException
    2. 即把自定义异常做成 运行时异常，好处是可以使用默认的处理机制，比较方便
    （如果定义为编译异常或者是它们的父类Exception，则在调用者处也要throws）
    3. 如果希望throw抛出异常后继续执行，需要将throw异常代码包裹try - catch（这里的if()也可以看作 异常代码）
    这样，程序就可以继续执行。---本质就是：throw 并没有处理异常，只是抛出了而已。catch可以捕获在try{}代码块中虚拟机抛出的异常，也能捕获手动创建的异常
    4. throw,相当于return。之后的代码不会执行。后面写代码则在编译器中就报错了，除非使用catch获取异常，或者if分支中进行throw。
    大多情况下，都是用if 来进行 throw 的，并且用catch包裹。
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
       // } catch (Exception e) { //catch了throw的异常，之后的程序就能继续执行
           // System.out.println(e.getMessage());
       // }
        System.out.println("程序继续");
    }

    public static void testTry() {
        try {
            //try中可以用throw，throw正好被catch捕获。
            throw new RuntimeException("123");
        } catch (Exception e) {

        }
    }

    //让try-catch白捕获
    public void test() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw e;
        }
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
