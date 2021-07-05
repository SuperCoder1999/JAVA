package chapter16tankgame01.tankgamev1;

import javax.swing.*;
import java.awt.*;

/*
    坦克大战的绘图区
 */

public class MyPanel extends JPanel {
    MyTank myTank = null;

    public MyPanel() {
        myTank = new MyTank(100, 100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(myTank.getX(), myTank.getY(), g, 0, 0);
    }

    /**
     * @param x      坦克的左上角坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
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
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y, x + 20, y + 30);//画出炮筒
                // false和true的比较，false更亮些
//                g.setColor(Color.cyan);
//                g.fill3DRect(300,600,100,200,false);
//                g.fill3DRect(300,100,100,200,true);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}
