package recording.io_;

import java.io.File;

public class ListFilesTest {
    public static void main(String[] args) {
        String pathName = "E:/Github/Web/Html/";
        File f = new File(pathName);
        if (!f.exists()) {
            System.out.println("No file");
            return;
        }

        //递归方式 遍历文件 --- 有些像 二叉树先序遍历
        /**
         * “真正地” 遍历文件 可以采用 二叉树层序遍历思想 - 队列实现
         */
        myListFile(f);
    }

    static void myListFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                myListFile(f);
            System.out.println(f);
        }
    }
}
