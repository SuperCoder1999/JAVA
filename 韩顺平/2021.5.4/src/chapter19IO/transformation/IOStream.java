package chapter19IO.transformation;

import org.junit.jupiter.api.Test;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/4/1 21:32
 * Description
 */
public class IOStream {
    //测试字符串的编码转换,底层对于编码的转换和InputStreamReader/OutputStreamWriter的原理有点像
    //并且字符串的编码转换更难一些,比如为啥,这里的通过GBK编码的创建字符串可以在UTF8的控制台输出?
    @Test
    public void testTrans() throws Exception {
        String s = "你好";
        byte[] utf8s = s.getBytes("UTF8");
        String s1 = new String(utf8s, "UTF8");
        System.out.println(s1);

        byte[] gbks = s.getBytes("GBK");
        String s2 = new String(gbks, "GBK");
        System.out.println(s2);
    }
}
