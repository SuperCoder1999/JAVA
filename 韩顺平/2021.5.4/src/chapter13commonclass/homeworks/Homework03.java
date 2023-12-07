package chapter13commonclass.homeworks;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Willian Jefferson Clinton";
        System.out.println(changeName(name));

        name = "Han shun Ping";
        System.out.println(changeName(name));
    }

    public static String changeName(String name) {
        char[] names = name.toCharArray();
        int head = name.indexOf(' ');
        int tail = name.lastIndexOf(' ');
        int length = 2 + head + 1 + (name.length() - tail) + 1;

        char[] chars = new char[length];
        int j = 0;
        for (int i = tail + 1; i < names.length; i++, j++) {
            chars[j] = names[i];
        }
        chars[j++] = ',';
        for (int i = 0; i <= head; i++) {
            chars[j++] = names[i];
        }
        chars[j++] = '.';
        chars[j] = names[head + 1];

        return new String(chars);
    }
}

    // =======================  参考方法  =================
/*
public class Homework03 {
    public static void main(String[] args) {
        String name = "Willian Jefferson Clinton";
        printName(name);
    }

public static void printName(String str) {

    if(str == null) {
        System.out.println("str 不能为空");
        return;
    }

    String[] names = str.split(" ");
    if(names.length != 3) {
        System.out.println("输入的字符串格式不对");
        return;
    }

    String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
    System.out.println(format);
}
}

 */