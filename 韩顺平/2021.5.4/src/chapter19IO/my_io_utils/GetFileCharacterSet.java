package chapter19IO.my_io_utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Jain Nieh
 * Environment AppleTree
 * Date 2023/4/1 15:03
 * Description 获取文件的编码格式
 * 1.这些代码不是我写的,我的能力还不能完全分析出来原理
 */
public class GetFileCharacterSet {
    /**
     * 获取文件的编码格式
     * @param file 源文件路径
     * @return 编码方式
     */
    public static String getCharset(File file) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            //BufferedInputStream bis = new BufferedInputStream(
            //new FileInputStream(file));
            //bis.mark(0);
            //int read = bis.read(first3Bytes, 0, 3);
            InputStream is = new FileInputStream(file);
            int read = is.read(first3Bytes, 0, 3);

            if (read == -1)
                return charset;
            //Log.i(TAG,"[GetCharset]first3Bytes[0]:"+first3Bytes[0]+", first3Bytes[1]:"+first3Bytes[1]+",first3Bytes[2]:"+first3Bytes[2]);
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xA
                    && first3Bytes[1] == (byte) 0x5B
                    && first3Bytes[2] == (byte) 0x30) {
                charset = "UTF-8";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xD
                    && first3Bytes[1] == (byte) 0xA
                    && first3Bytes[2] == (byte) 0x5B) {
                charset = "GBK";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0x5B
                    && first3Bytes[1] == (byte) 0x54
                    && first3Bytes[2] == (byte) 0x49) {
                charset = "windows-1251";
                checked = true;
            }
            //bis.reset();
            InputStream istmp = new FileInputStream(file);
            if (!checked) {
                int loc = 0;
                while ((read = istmp.read()) != -1) {
                    loc++;
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF)
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = istmp.read();
                        if (0x80 <= read && read <= 0xBF)
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {
                        read = istmp.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = istmp.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            is.close();
            istmp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }
}
