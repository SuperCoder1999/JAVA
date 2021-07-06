package chapter16tankgame01.tankgamev2;

import chapter14jihe.collection_.list_.vector.Vector_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/*
    坦克大战的绘图区
 */

public class MyPanel extends JPanel implements KeyListener {
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = null;
    int enemyTankSize;
    public MyPanel() {
        myTank = new MyTank(100, 100, 0, 10, 1);
        enemyTanks = new Vector<>();
        enemyTankSize = 3;
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(100 * (1 + i),0,2,3,0));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), myTank.getType());
        for (int i = 0; i < enemyTankSize; i++) {
            drawTank(enemyTanks.get(i).getX(), enemyTanks.get(i).getY(),
                    g, enemyTanks.get(i). getDirect(), enemyTanks.get(i).getType());
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            if (myTank.getDirect() != 0)
                myTank.setDirect(0);
            else myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (myTank.getDirect() != 2)
                myTank.setDirect(2);
            else myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (myTank.getDirect() != 3)
                myTank.setDirect(3);
            else myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (myTank.getDirect() != 1)
                myTank.setDirect(1);
            else myTank.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * @param x      坦克的左上角坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）(0: 向上 1 向右 2 向下 3 向左 )
     * @param type   坦克类型 0： 敌方   1：己方
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y, x + 20, y + 30);//画出炮筒
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10,false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10,false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10,20,20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 60, x + 20, y + 30);//画出炮筒
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10,false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10,false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10,20,20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

}
