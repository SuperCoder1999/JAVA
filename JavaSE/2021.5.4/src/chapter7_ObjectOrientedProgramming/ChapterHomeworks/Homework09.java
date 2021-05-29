package chapter7objectorientedprogrammingprimary.ChapterHomeworks;

/*
    定义Music类，里面有音乐名name、音乐时长times属性，
    并有播放play功能和返回本身属性信息的功能方法getInfo
 */
public class Homework09 {
    public static void main(String[] args) {
        Music aMusic = new Music("Lemon", 300);
        aMusic.play();
        System.out.println(aMusic.getInfo());
    }
}

class Music {
    String name;
    int times;

    public Music(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public void play() {
        System.out.println("正在播放 " + this.name);
    }

    public String getInfo() {
        return "歌名：" + name + " 时长：" + times + "秒";
    }
}