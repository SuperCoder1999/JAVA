package chapter16tankgame01.draw;

import javax.swing.*;
import java.awt.*;

public class GraphicsMethods extends JFrame {
    MyPanel1 myPanel1 = null;

    public static void main(String[] args) {
        new GraphicsMethods();
    }

    public GraphicsMethods() {
        myPanel1 = new MyPanel1();
        this.add(myPanel1);
        this.setSize(400, 300);
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel1 extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ////设置画笔的颜色 setColor(Color c)
        //g.setColor(Color.blue);

        //画直线 drawLine(int x1,int y1,int x2,int y2)
        //g.drawLine(0,20,500,20);// 可以越界

        //画矩形边框 drawRect(int x, int y, int width, int height)
        //g.drawRect(10, 10, 100, 100);

        //画椭圆边框 drawOval(int x, int y, int width, int height)

        //填充矩形 fillRect(int x, int y, int width, int height)
        //g.setColor(Color.blue); // 设置填充颜色
        //g.fillRect(10, 10, 100, 100);//默认是灰黑色

        //填充椭圆 fillOval(int x, int y, int width, int height)
        //g.setColor(Color.red);
        //g.fillOval(10, 10, 100, 100);//默认是灰黑色

        //画图片 drawImage(Image img, int x, int y, ..)
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
        g.drawImage(image, 10, 10, 175, 221, this);

        //画字符串 drawString(String str, int x, int y)//写字
        //给画笔设置颜色和字体
        g.setColor(Color.red);
        //设置画笔的字体 setFont(Font font)
        g.setFont(new Font("隶书", Font.BOLD, 50));
        //这里设置的 100， 100， 是 "北京你好"左下角
        g.drawString("北京你好", 100, 100);
    }
}