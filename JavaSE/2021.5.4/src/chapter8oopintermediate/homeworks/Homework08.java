package chapter8oopintermediate.homeworks;

public class Homework08 {
    public static void main(String[] args) {
//        CheckingAccount tom = new CheckingAccount(1000);
//        tom.deposit(100);
//        System_.out.println(tom.getBalance());//1099
//        tom.withdraw(99);
//        System_.out.println(tom.getBalance());//999

        SavingAccount jack = new SavingAccount(1000);
        jack.deposit(100);//1100
        jack.withdraw(10);//1090
        jack.deposit(20);//1110
        System.out.println(jack.getBalance());
        jack.withdraw(10);
        System.out.println(jack.getBalance());//1099
        jack.deposit(2);//1100
            //可以写一个时间方法用来按时调用这个方法来初始化次数及计算利息
        jack.earnMonthlyInterest();//1210
        System.out.println(jack.getBalance());
        jack.deposit(100);//1310
        jack.withdraw(10);//1300
        jack.deposit(20);//1320
        System.out.println(jack.getBalance());
    }
}

class BankAccount {//父类
    private double balance;//余额

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //存款
    public void deposit(double amount) {
        balance += amount;
    }

    //取款
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount - 1);//通过少存1元来实现扣除手续费
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount + 1);//多取一元来扣除手续费
    }

}

class SavingAccount extends BankAccount {
    private double rate = 0.1;
    private int count = 3;

    public SavingAccount(double initialBalance) {
        super(initialBalance);
    }

    // 产生利息直接存入账户
    public void earnMonthlyInterest() {
        count = 3;
        super.deposit(super.getBalance() * this.rate);
    }

    @Override
    public void deposit(double amount) {
        if (count > 0) {
            super.deposit(amount);
            count--;
        } else
            super.deposit(amount - 1);
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0) {
            super.withdraw(amount);
            count--;
        } else
            super.withdraw(amount + 1);
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}