package chapter16tankgame01.tankgamev2;

import javax.swing.*;

/**
 *
 */

public class TankGameV2 extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankGameV2();
    }

    public TankGameV2() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
