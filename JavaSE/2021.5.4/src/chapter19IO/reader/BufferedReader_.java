package chapter19IO.reader;
import java.io.BufferedReader;
import java.io.FileReader;

/*
    1. BufferedReader和BufferedWriter属于字符流，是按照字符来读取数据的【读取二进制文件可能出现损失】
    2. 关闭时，只需要关闭外层流即可【底层是关闭节点流】
 */

public class BufferedReader_ {
    public static void main(String[] args) throws Exception {

        String filePath = "e:\\a.java";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取, 效率高
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流FileReader
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }

         */
        bufferedReader.close();

    }
}