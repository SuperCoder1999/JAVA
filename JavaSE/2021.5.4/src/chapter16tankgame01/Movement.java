package chapter16tankgame01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
        ---------Java时间处理机制--------
    一:基本说明
    1. Java时间处理是采用“委派时间模型”。当事件发生时，产生事件的对象会把此“信息”传递给“事件的监听者”处理。
    这里所说的“信息”实际上就是java.awt.event 事件类库里某个类所创建的对象，把它称为“事件的对象”（并非是产生事件的对象）。
    实例：由于this.addKeyListener(myPanel);，如果键盘上产生一个事件。此时监听者 KeyListener 就会
    产生一个KeyEvent对象，所以KeyEvent就是事件的信息/事件的对象。

    2. 用户操作 事件源 产生了事件 传入到 事件监听者
    3. 如何让一个对象成为事件的监听者（监听者可能和事件发生源处于同一个事物上）：需要类去实现相应的监听器接口

    二：事件处理机制深入理解
    


 */

public class Movement extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {
        new Movement();
    }

    public Movement() {
        myPanel = new MyPanel();
        this.add(myPanel);
        //窗口JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        // 也就是说：鼠标选择 游戏窗口（面板）后，键盘输入的内容就会被监听
        this.addKeyListener(myPanel);
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动，需要设置一个存储位置的变量用来变化；拟定左上角(x,y)
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);

    }

    @Override
    //有字符输出时，该方法就会触发
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //当某个键按下，该方法会触发
    public void keyPressed(KeyEvent e) {
        //System.out.println((char)e.getKeyCode() + "被按下~");

        //根据用户按下的不同键，来处理小球的移动 (上下左右的键)
        //在java中，会给每一个键，分配一个值(int)
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            y++;
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            y--;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            x--;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            x++;
        // 其实，每次触发监听，就会调用一次监听方法。所以没必要在每一个if中添加repaint()
            this.repaint();
    }

    @Override
    //当某个键释放(松开)，该方法会触发
    public void keyReleased(KeyEvent e) {

    }
}