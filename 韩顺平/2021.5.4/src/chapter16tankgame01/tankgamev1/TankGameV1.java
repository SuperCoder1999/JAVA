package chapter16tankgame01.tankgamev1;

import javax.swing.*;

/**
 *  目前坦克游戏第一版本，只绘出 游戏窗口、画板、地方静态坦克（敌方蓝色）
 */

public class TankGameV1 extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankGameV1();
    }

    public TankGameV1() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
