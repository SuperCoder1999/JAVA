package chapter16tankgame01.movement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
        ---------Java时间处理机制--------
    一:基本说明
    1. Java事件处理是采用“委派事件模型”。
    当用户操作事件源产生了事件  被事件监听者察觉就会产生一个事件对象  事件对象中有各种所需信息监听者再借助信息进行必要操作。

    这里所说的对象就是java.awt.event 事件类库里某个类所创建的对象，把它称为“事件的对象”（产生事件的对象，称为事件源）。
    实例：由于this.addKeyListener(myPanel);即TankGameV1游戏面板被myPanel监听，
    如果当前活动窗口是游戏面板，一旦键盘上产生一个事件。此时监听者 myPanel(监听者应该可以单独定义一个类出来) 就会
    产生一个KeyEvent对象，在myPanel(监听者)中有一个方法，来获取事件对象，并借助事件对象信息进行必要操作。
        1）myPanel是监听者
        2）TankGameV1游戏面板
        3）KeyEvent就是事件的信息/事件的对象。

    2. 用户操作事件源 产生了事件被事件监听者察觉并产生一个事件对象  事件对象中有各种所需信息监听者再借助事件对象信息进行必要操作
    3. 如何让一个对象成为事件的监听者（监听者和事件发生源处于同一个事物上）：
    一个类去实现相应的监听器接口，创建这个对象，并this.addKeyListener(myPanel);
    示例：class MyPanel extends JPanel implements KeyListener {} // 这里是将监听者和画板和为同一对象了

    二：事件处理机制深入理解
    1. 事件源：事件源是一个产生事件的对象，比如按钮、窗口等
    2. 事件：事件就是承载事件源状态改变时的对象。比如当键盘事件、鼠标事件、窗口事件等发生时，会生成一个事件对象，
    该对象保存着当前事件很多信息，比如KeyEvent对象含有被按下键的Code值。
    java.awt.event包和javax.swing.event包中定义了各种事件类型。
    3. 事件类型 查阅jdk文档可以看到
    4. 事件监听器接口
        1）当事件源产生一个事件，事件监听者就会产生事件对象并借助事件对象的信息进行操作
        2）事件监听者其实就是一个类实例化的对象，该类实现了某个事件监听器接口。
            例如:MyPanel就是监听者类，其实例化后的对象myPanel 就是事件监听器。
        3）监听器需要添加到事件源上才能监听到事件，即this.addKeyListener(myPanel);
        4）事件监听器接口有多种，不同的事件监听器接口可以监听不同的事件，一个类可以实现多个监听接口。
        不同的事件监听器，将对其监听类型的事件监听，事件源产生该类型事件后，监听器就会产生该类型的事件对象。
        5）这些接口在java.awt.event包和javax.swing.event包中定义。

    


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