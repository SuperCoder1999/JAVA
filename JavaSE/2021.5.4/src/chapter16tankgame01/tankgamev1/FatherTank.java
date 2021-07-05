package chapter16tankgame01.tankgamev1;

/*
    因为场上有很多种坦克，且每一种都差不多。所以可以抽象出来一个父类，子类进行修改即可。
 */

public class FatherTank {
    // 暂时不知道 怎么规划 分部设计，就模仿着写
    private int x;
    private int y;

    public FatherTank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}