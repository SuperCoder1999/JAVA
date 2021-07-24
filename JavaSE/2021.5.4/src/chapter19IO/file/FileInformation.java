package chapter19IO.file;
import org.junit.jupiter.api.Test;
import java.io.File;
public class FileInformation {
    public static void main(String[] args) {

    }

    //获取文件的信息
    @Test
    public void info() {
        //先创建文件对象
        File file = new File("e:\\news1.txt");
        //File file = new File("e:\\123");

        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T - 文件是指不包含其他格式内容的文件
        System.out.println("是不是一个目录=" + file.isDirectory());//F - 目录是指文件中还可以有文件（文件夹即目录）
    }
}
