package recording.io_;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 打开流 关闭流 的操作
 */

public class AboutTryCatch {
    public static void main(String[] args) {

    }

    public void fileStream() {
        String srcPath = "E:/we";
        String destPath = "E:/ew";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
        } catch (FileNotFoundException e) {
            System.out.println("流 创建 失败");
        } finally {

            try {
                //这里会有 NullPointException 空指针异常  不属于IOException
                //所以最好用 if 进行判断
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("关闭流 出错");
            }

        }
    }

    /**
     * try() catch 新的操作. try中自动释放资源(关闭流)
     */
    @Test
    public void newTryCatchTest() {
        String srcPath = "E:/we";
        String destPath = "E:/ew";

        try (FileInputStream fileInputStream = new FileInputStream(srcPath);
             FileOutputStream fileOutputStream = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            System.out.println("流 创建 失败");
        }
    }
}
