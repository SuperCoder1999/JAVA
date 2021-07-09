package chapter18tankgame02.tankgamev4;

import javax.swing.*;

/**
 *
 */

public class TankGameV4 extends JFrame {
    MyPanel myPanel = null;
    public static void main(String[] args) {
        new TankGameV4();
    }

    public TankGameV4() {
        myPanel = new MyPanel();
        Thread thread = new Thread(myPanel);
        thread.start();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
