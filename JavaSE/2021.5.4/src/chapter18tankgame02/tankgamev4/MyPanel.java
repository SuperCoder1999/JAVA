package chapter18tankgame02.tankgamev4;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/*
    坦克大战的绘图区
 */

public class MyPanel extends JPanel implements KeyListener , Runnable{
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = null;
    int enemyTankSize = 3;
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    public MyPanel() {
        myTank = new MyTank(100, 100, 0, 10, 1);
        enemyTanks = new Vector<>();
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (1 + i),0,2,3,0);
            Thread thread = new Thread(enemyTank);
            thread.start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
        //image3 = Toolkit.getDefaultToolkit().getImage("e:\\ok.jpg");

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), myTank.getType());

//        //画出myTank的子弹
//        if (myTank.shot != null && myTank.shot.isLive) { // 在没有按下j的情况下，shot并没有被创建
//            System.out.println("子弹被绘制");
//            g.fill3DRect(myTank.shot.x,myTank.shot.y,1,1,false);
//        }

        //绘制myTank子弹集合
        for (Shot s : myTank.shots) {
            if (s != null && s.isLive)
                g.fill3DRect(s.x, s.y, 1, 1, false);
            else
                myTank.shots.remove(s);
        }

        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6)
                g.drawImage(image1,bomb.x, bomb.y,60,60,this);
            else if (bomb.life > 3)
                g.drawImage(image2,bomb.x, bomb.y,60,60,this);
            else g.drawImage(image3,bomb.x, bomb.y,60,60,this);
            bomb.lifeDown();
            //如果bomb life 为0, 就从bombs 的集合中删除
            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(),
                        g, enemyTank.getDirect(), enemyTank.getType());
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    } else {
                        enemyTank.shots.remove(j);
                    }
                }
            }
        }
    }

    public void hitEnemyTank() {
                //遍历我们的子弹
        for(int j = 0;j < myTank.shots.size();j++) {
            Shot shot = myTank.shots.get(j);
            //判断是否击中了敌人坦克
            if (shot != null && myTank.shot.isLive) {//当我的子弹还存活

                //遍历敌人所有的坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(myTank.shot, enemyTank);
                }
            }
        }
    }

    public void hitTank(Shot s, EnemyTank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                if (s.x >= enemyTank.getX() && s.x <= enemyTank.getX() + 40 && s.y >= enemyTank.getY() &&
                s.y <= enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(enemyTank);
                }
                break;
            case 1: //坦克向右
            case 3: //坦克向左
                if (s.x >= enemyTank.getX() && s.x <= enemyTank.getX() + 60
                        && s.y >= enemyTank.getY() && s.y <= enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                    enemyTanks.remove(enemyTank);
                }
                break;
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
            else if (myTank.getY() > 0)
                myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            if (myTank.getDirect() != 2)
                myTank.setDirect(2);
            else if (myTank.getY() +60 < 750)
                myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            if (myTank.getDirect() != 3)
                myTank.setDirect(3);
            else if (myTank.getX()  > 0)
                myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            if (myTank.getDirect() != 1)
                myTank.setDirect(1);
            else if (myTank.getX() + 60 < 1000)
                myTank.moveRight();
        }
        //如果用户按下的是J,就发射
        if(e.getKeyCode() == KeyEvent.VK_J) {
//            //判断hero的子弹是否销毁,发射一颗子弹
//            if (myTank.shot == null || !myTank.shot.isLive) {
//                System.out.println("用户按下了J, 开始射击.");
//                myTank.shotEnemyTank();
//            }
            myTank.shotEnemyTank();
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
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (myTank.shot != null && myTank.shot.isLive) {
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(myTank.shot, enemyTank);
//                }
//            }
            //判断是我们子弹否击中了敌人坦克
            hitEnemyTank();

            this.repaint();
            //System.out.println("重绘"); 从这里可以看出，即使窗口并没有变化，还是在重绘
        }
    }
}
