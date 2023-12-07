package chapter10oopsenior.main_;
/*
 如何在idea中传递参数给main函数
    1. open edit run/debug configuration dialog 【注意窗口需要显示需要运行的main方法】
    2. 进入 edit configuration 在 Programme argument 内编辑内容【之后一直保留这些内容，除非删除】
 */
public class MainParameter {
    public static void main(String[] args) {
        for ( int i = 0; i < args.length; i++ ) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}
