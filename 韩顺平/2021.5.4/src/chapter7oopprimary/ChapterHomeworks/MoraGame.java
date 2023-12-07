package chapter7oopprimary.ChapterHomeworks;

/*
    请编写一个猜拳的游戏
    有个人 Tom，设计他的成员变量. 成员方法, 可以电脑猜拳. 电脑每次都会随机生成 0, 1, 2
    0 表示 石头 1 表示剪刀 2 表示 布
    并要可以显示 Tom的输赢次数（清单）, 假定 玩三次.
 */
import java.util.Scanner;

public class MoraGame {
    public static void main(String[] args) {
        Computer aComputer = new Computer();
        Gamer aGamer = new Gamer();
        Judge aJudge = new Judge();

        int lose = 0;
        int win = 0;
        int tie = 0;

        for (int i = 0; i < 3; i++) {
            int computer = aComputer.computer();
            int gamer = aGamer.enter();
            if (aJudge.judge(computer, gamer) == 1)
                win++;
            else if (aJudge.judge(computer, gamer) == -1)
                lose++;
            else
                tie++;
            System.out.println("==========================" +
                    "\n" + "局数\t" + "玩家出拳\t" + "电脑出拳\t" + "结果");
            System.out.println(i+1 + "\t\t" + gamer + "\t\t" + computer + "\t\t" + aJudge.judge(computer, gamer));
            System.out.println("==========================\n\n");
        }
        System.out.println("lose: " + lose + " win: " + win + " tie:" + tie);
    }
}

class Computer {
    public int computer() {
        return (int) (Math.random() * 3);
    }
}

class Gamer {
    public int enter() {
        System.out.println("Enter :(0 表示 石头 1 表示剪刀 2 表示 布) ");
        Scanner myScanner = new Scanner(System.in);
        return myScanner.nextInt();
    }
}

class Judge {

    public int judge(int computer, int gamer) {
        if (computer - gamer == -1 || computer - gamer == 2)
            return -1;
        else if (computer - gamer == 0)
            return 0;
        else
            return 1;
    }
}