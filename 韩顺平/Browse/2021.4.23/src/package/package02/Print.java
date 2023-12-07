package package02;

/**
 * 视频中复制之后，类名前面全部带有包名(前面这句话可能是说:从一个Idea工程中复制Java代码过来,会将类名添加全类名[之前遇到过])
 * 我想，如果类的修饰符是public 且两个包中没有相同名字的类，则不需用包名(包名必须加在别的包下的类前面,不可以省略,前提是满足访问修饰符)
 */
public class print {
    public void print01(){
        System.out.println("class of package02");
    }
}
