package chapter13commonclass.homeworks;
/**
 * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
 * 要求：
 * (1) 用户名长度为2或3或4
 * (2) 密码的长度为6，要求全是数字  自己创建 isDigital方法
 * (3) 邮箱中包含@和.   并且@在.的前面
 * <p>
 * 思路分析
 * (1) 先编写方法 userRegister(String name, String pwd, String email) {}
 * (2) 针对 输入的内容进行校核，如果发现有问题，就抛出异常，给出提示
 * (3) 单独的写一个方法，判断 密码是否全部是数字字符 boolean
 */
public class Homework02 {
    public static void main(String[] args) {
        String name = "abcd";
        String pwd = "123456";
        String email = "ti@isohu.com";

        try {
            if (userRegister(name, pwd, email))
                System.out.println("Success");
            else
                System.out.println("fail");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean userRegister(String name, String pwd, String email) {

        // 即使没有这条判断是null的语句，在之后调用name.length()、pwd.length()、
        // email.indexOf('@') 这些方法时，都会抛出异常
        if (!(name != null && pwd != null && email != null))
            throw new RuntimeException("参数有误");
        if (!(name.length()>=2 && name.length() <= 4)) {
            System.out.println("用户名错误");
            return false;
        }
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            System.out.println("密码格式错误");
            return false;
        }
        if (!(email.indexOf('@') != -1 && email.indexOf('.') != -1
                && email.indexOf('@') < email.indexOf('.'))) {
            System.out.println("邮箱格式错误");
            return false;
        }
        return true;
    }

    public static boolean isDigital(String pwd) {
        char[] chars = pwd.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
