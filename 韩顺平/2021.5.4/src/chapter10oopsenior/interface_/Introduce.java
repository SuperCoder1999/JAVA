package chapter10oopsenior.interface_;
/*
    一：简介
    1. 接口这个设计在Java编程/php/.net/go 中都有大量存在
    2. 接口仿佛就是框架、事先提供的模板。这样对于所有要用到接口内的方法的类，都有一定良好的规范性
 */
public class Introduce {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        Computer computer = new Computer();
        computer.computer(phone);
        computer.computer(camera);
    }
}

class Computer {
    // 调用实现接口的对象时 类似于向上转型
    public void computer(UsbInterface usbInterface) {
        usbInterface.start();
        usbInterface.end();
    }
}
 // 接口仿佛就是框架、事先提供的模板，
 // 这样对于所有要用到接口内的方法的类，都有一定良好的规范性
interface UsbInterface {
    // 规定接口的相关方法
    public void start();

    public void end();
}

class Phone implements UsbInterface{
    public void start() {
        System.out.println("手机开机");
    }

    public void end() {
        System.out.println("手机关机");
    }
}

class Camera implements UsbInterface {
    @Override
    public void start() {
        System.out.println("相机开机");
    }

    @Override
    public void end() {
        System.out.println("相机关机");
    }

}