package chapter16tankgame01.draw;
import javax.swing.*;
import java.awt.*;
/*
    一：java绘图快速入门

    二：Component类提供了两个和绘图相关的最重要的方法：
    1. paint(Graphics g)绘制组件的外观
    2. repaint() 刷新组件的外观

    三：
    1. 当组件第一次在屏幕显示的时候，程序会自动调用paint()方法来绘制组件 --- 为何显示出来的paint被调用了两次
    2. 在以下情况paint()再次被调用
        1)窗口最小化再最大化
        2）窗口的大小发生变化（被调用好多次)
        3)repaint()函数被调用
 */
public class DrawCircle extends JFrame { // JFrame对应窗口，可以理解为一个画框

    // 定义一个面板
    MyPanel myPanel = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() { // 构造器
        // 初始化面板
        myPanel = new MyPanel();
        // 将面板添加到窗口（画框）
        this.add(myPanel);
        // 设置窗口的大小--画框的大小
        this.setSize(400,300);
        // 使画框内容可以显示
        this.setVisible(true);

        // 当点击窗口的关闭，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// 先定义一个MyPanel，继承JPanel类，用于画图。相当于画板
class MyPanel extends JPanel {

    // 绘图方法 可以将Graphics g 认为是 画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 调用父类的方法完成初始化 ---- 可以认为是传入画笔

        // Graphics类提供的画图方法 --- 画一个椭圆
        g.drawOval(10, 10, 100, 100);

        // 查看paint方法被调用情况
        System.out.println("paint 方法被调用~ ");
    }
}
//@SuppressWarnings({"all"})
//public class DrawCircle extends JFrame { //JFrame对应窗口,可以理解成是一个画框
//
//    //定义一个面板
//    private MyPanel mp = null;
//
//    public static void main(String[] args) {
//        new DrawCircle();
//        System.out.println("退出程序~");
//    }
//
//    public DrawCircle() {//构造器
//        //初始化面板
//        mp = new MyPanel();
//        //把面板放入到窗口(画框)
//        this.add(mp);
//        //设置窗口的大小 画框大小
//        this.setSize(400, 300);
//        //当点击窗口的小×，程序完全退出.
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);//可以显示
//    }
//}
//
////1.先定义一个MyPanel, 继承JPanel类， 画图形，就在面板上画
//class MyPanel extends JPanel {
//
//
//    //说明:
//    //1. MyPanel 对象就是一个画板
//    //2. Graphics g 把 g 理解成一支画笔
//    //3. Graphics 提供了很多绘图的方法
//    //Graphics g
//    @Override
//    public void paint(Graphics g) {//绘图方法
//        super.paint(g);//调用父类的方法完成初始化.一定保留
//        System.out.println("paint 方法被调用了~");
//        //画出一个圆形.
//        g.drawOval(0, 0, 100, 100);
//
//
//        //演示绘制不同的图形..
//        //画直线 drawLine(int x1,int y1,int x2,int y2)
//        g.drawLine(10, 10, 100, 100);
//        //画矩形边框 drawRect(int x, int y, int width, int height)
//        //g.drawRect(10, 10, 100, 100);
//        //画椭圆边框 drawOval(int x, int y, int width, int height)
//        //填充矩形 fillRect(int x, int y, int width, int height)
//        //设置画笔的颜色
////        g.setColor(Color.blue);
////        g.fillRect(10, 10, 100, 100);
//
//        //填充椭圆 fillOval(int x, int y, int width, int height)
////        g.setColor(Color.red);
////        g.fillOval(10, 10, 100, 100);
//
//        //画图片 drawImage(Image img, int x, int y, ..)
//        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
////        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
////        g.drawImage(image, 10, 10, 175, 221, this);
//        //画字符串 drawString(String str, int x, int y)//写字
//        //给画笔设置颜色和字体
//        //g.setColor(Color.red);
//        //g.setFont(new Font("隶书", Font.BOLD, 50));
//        //这里设置的 100， 100， 是 "北京你好"左下角
//        //g.drawString("北京你好", 100, 100);
//        //设置画笔的字体 setFont(Font font)
//        //设置画笔的颜色 setColor(Color c)
//
//
//    }
//}
