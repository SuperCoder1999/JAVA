package chapter19IO.charsstream.jiedianliu;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

        String filePath = "e:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
//            3) write(int):写入单个字符
            fileWriter.write('H');
//            4) write(char[]):写入指定数组
            fileWriter.write(chars);
//            5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(), 0, 3);// "123".toCharArray();方法
//            6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
//            7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2);
            //在数据量大的情况下，可以使用循环操作.
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //对应FileWriter , 一定要关闭流，或者flush才能真正的把数据写入到文件
            //老韩看源码就知道原因.源码分析不出啥
            /*
            看看代码
            private void writeBytes() throws IOException {
                this.bb.flip();
                int var1 = this.bb.limit();
                int var2 = this.bb.position();

                assert var2 <= var1;

                int var3 = var2 <= var1 ? var1 - var2 : 0;
                if (var3 > 0) {
                    if (this.ch != null) {
                        assert this.ch.write(this.bb) == var3 : var3;
                    } else {
                        this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                    }
                }

                this.bb.clear();
            }
             */
            try {
                //刷新输出流的原因:
                /*
                1.Java出于性能考虑,首先将数据写到Buffer,当Buffer满了再将Buffer中的数据写入/输出到文件或控制台.
                2.当缓冲区Buffer被部分填充并且没有要写入的东西了,则Buffer会继续等待.此时需要手动要求其写入.
                3.Java底层许多输出流的close()自带flush()功能,所以及时关闭流也能做到刷新输出流
                 */
                //fileWriter.flush();
                //关闭文件流，等价 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("程序结束...");


    }
}
