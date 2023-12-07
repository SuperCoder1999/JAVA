package chapter8oopintermediate.extend.extendexercise;

/*
    编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回Computer的详细信息
    编写PC子类，继承Computer类，添加特有属性【品牌brand】
    编写NotePad子类，继承Computer类，添加特有属性【color】//同学们自己写。
    编写Test类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性赋值，
    以及从Computer类继承的属性赋值，并使用方法并打印输出信息
 */

public class ExtendExercise03 {
    public static void main(String[] args) {
        PC pc = new PC();
        pc.setCpu("Intel");
        pc.setMemory(16);
        pc.setDisk(1024);
        pc.setRand("lenovo");
        System.out.println("pc: " + pc.getCpu() + " " + pc.getMemory() + " " +
                pc.getDisk() + " " + pc.getRand());
        System.out.println("\npc: " + pc.getInfo01());

        PC pc1 = new PC("RMD", 32, 512, "Lenovo");
        System.out.println("\npc1: " + pc1.getCpu() + " " + pc1.getMemory() + " " +
                pc1.getDisk() + " " + pc1.getRand());

        NotePad notePad = new NotePad();
        notePad.setCpu("Intel");
        notePad.setMemory(16);
        notePad.setDisk(1024);
        notePad.setColor("银色");
        System.out.println("\n\nNotePad : " + notePad.getCpu() + " " + notePad.getMemory() + " " +
                notePad.getDisk() + " " + notePad.getColor());
        System.out.println("\nNotePad: " + notePad.getInfo02());

        NotePad notePad1 = new NotePad("RMD", 32, 512, "Black");
        System.out.println("\nNotePad1 : " + notePad1.getCpu() + " " + notePad1.getMemory() + " " +
                notePad1.getDisk() + " " + notePad1.getColor());

    }
}

// computer 属性 两个构造器  set get 方法
// PC NotePad 两个构造器 第二个构造器需要指定调用super构造器
class Computer {
    private String cpu;
    private int memory;
    private int disk;

    public Computer() {

    }

    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public String getInfo() {
        return "CPU: " + cpu +"  内存：" + memory + "  硬盘：" + disk;
    }
}

class PC extends Computer{
    private String rand;
    public PC() {

    }

    public PC(String cpu, int memory, int disk, String rand) {
        super(cpu, memory, disk);
        this.rand = rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
    }

    public String getRand() {
        return rand;
    }

    public String getInfo01() {
        return getInfo() + "  品牌：" + rand;
    }
}

class NotePad extends Computer{
    private String color;

    public NotePad() {

    }

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getInfo02() {
        return getInfo() + "  颜色：" + color;
    }
}

// 错误中体现的细节：
class F {
    String name;

    public F(String name) {

    }
}

// class S extends F{  //报错原因：类S 中有默认无参构造器，此时这个无参构造器默认调用类 F的
                        // 无参构造器，但是类 F中无参构造器已被覆盖

//}