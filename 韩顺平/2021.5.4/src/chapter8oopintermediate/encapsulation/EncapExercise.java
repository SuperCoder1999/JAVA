package chapter8oopintermediate.encapsulation;

/**
 * 创建程序,在其中定义两个类：Account和AccountTest类体会Java的封装性。
 * Account类要求具有属性：姓名（长度为2位3位或4位）、余额(必须>20)、
 * 密码（必须是六位）, 如果不满足，则给出提示信息，并给默认值(程序员自己定)
 * 通过setXxx的方法给Account 的属性赋值。
 * 在AccountTest中测试
 */
public class EncapExercise {
    public static void main(String[] args) {
        AccountTest accountTest = new AccountTest();
        accountTest.test();
    }
}

class AccountTest {
    public void test() {
        Account account1 = new Account();
        account1.setName("jack");
        account1.setBalance(1000);
        account1.setPassword("99112");
        System.out.println(account1.info());

        System.out.println("==============");
        Account tom = new Account("Tom", 20, "33115n");
        System.out.println(tom.info());

    }
}

class Account {

    private String name;
    private double balance;
    private String password;

    // 构造器赋值
    public Account() {
        // 无参构造器
    }

    public Account(String name, double balance, String password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    // set & get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 4 && name.length() >= 2)
            this.name = name;
        else {
            System.out.println("name 无效,姓名（长度为2位3位或4位）");
            this.name = "用户";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20)
            this.balance = balance;
        else {
            System.out.println("余额不足，余额(必须>20)");
            this.balance = -1;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6)
            this.password = password;
        else {
            this.password = "000000";
            System.out.println("密码（必须是六位）");
        }
    }

    public String info() {
        return "姓名：" + this.name + "  余额=" + this.balance + " 密码：" +
                this.password;
    }
}