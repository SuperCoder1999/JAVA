package chapter18tankgame02.tankgamev4;

/*
    因为场上有很多种坦克，且每一种都差不多。所以可以抽象出来一个父类，子类进行修改即可。
 */

public class FatherTank {
    // 暂时不知道 怎么规划 分部设计，就模仿着写
    private int x;
    private int y;
    private int direct;
    private int speed;
    private int type;
    boolean isLive = true;

    public FatherTank(int x, int y, int direct,int speed, int type) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
        this.type = type;
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

    public int getDirect() {
        return direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void moveUp() {
        this.y -= speed;
    }

    public void moveRight() {
        this.x += speed;
    }

    public void moveDown() {
        this.y += speed;
    }

    public void moveLeft() {
        this.x -= speed;
    }
}