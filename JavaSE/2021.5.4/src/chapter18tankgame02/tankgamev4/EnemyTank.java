package chapter18tankgame02.tankgamev4;

/*
    1. 因为敌人的坦克，以后有自己特殊的属性和方法，所以单开一个EnemyTank类。
    2. 敌人坦克数量多，可以考虑放入集合Vector中(Vector是线程安全的)
 */

import java.util.Vector;

public class EnemyTank extends FatherTank implements Runnable {
    Vector<Shot> shots = new Vector<>();

    public EnemyTank(int x, int y, int direct, int speed, int type) {
        super(x, y, direct, speed, type);
    }

    @Override
    public void run() {
        while (true) {
            //根据坦克的方向继续移动
            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) { // 循环30次+每次休息50ms作用是：在1.5s内前进30次。避免瞬移的情况
                        if (super.getY() > 0)
                            super.moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (super.getX() + 60 < 1000)
                            super.moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (super.getY() + 60 < 750)
                            super.moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (super.getX() > 0)
                            super.moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //然后随机的改变坦克方向
            super.setDirect((int) (Math.random() * 4));// [0,4)
            //一旦写并发程序，一定要考虑什么时候退出线程
            if (!super.isLive) {
                break;
            }
        }
    }
}
