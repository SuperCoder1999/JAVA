package chapter12exception.trycatch;

/*
    一：
        try-catch 和 throw 只能选择一个。
        有 try-catch 处理异常之后，程序就不会直接退出，提高健壮性

    二：
        Java提供try和catch块来处理异常。try块用于包含可能出错的代码。
      catch块用于处理try块中发生的异常。可以根据需要在程序中有多个try-catch块

    三：try-catch-finally
    try {

    代码/可能有异常

    1. 当异常发生时
    2. 系统将异常封装成类Exception的对象 e，传给catch

    } catch(Exception e) {


    3. 得到异常对象后，程序员自己处理
    4. 注意，如果没有发生异常，catch代码块不执行

    }finally {（没有finally是允许的）

    1. 不管try代码块是否有异常发生，始终要执行finally
    2. 所以，通常将释放资源的代码，放在finally

    }


    四：细节：
    1. 如果try中发生异常，则异常之后直到catch的代码都不会执行。而是直接进入到catch中
    2. 如果异常没有发生，则顺序执行try的代码块，不会进入到catch
    3. 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)则使用如下代码- finally
    4. catch执行完成后一定执行finally，如果catch中有return。先保存临时变量去执行finally，之后返回临时变量
 */

public class TryCatchDetail01 {
    public static void main(String[] args) {

        //解读
        //1. 如果异常发生了，则异常发生后面的代码不会执行，直接进入到catch块
        //2. 如果异常没有发生，则顺序执行try的代码块，不会进入到catch
        //3. 如果希望不管是否发生异常，都执行某段代码(比如关闭连接，释放资源等)则使用如下代码- finally
        try {
            String str = "韩顺平";
            int a = Integer.parseInt(str);
            System.out.println("数字：" + a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息=" + e.getMessage());
        } finally {
            System.out.println("finally代码块被执行...");
        }

        System.out.println("程序继续...");

    }
}