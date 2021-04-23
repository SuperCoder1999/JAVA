package package01;

 // 父类，Pupil 和 Graguate 的父类
public class Students {
    public String name;
    public int age;
    private double score;

     public void setScore(double score) {
         this.score = score;
     }

     public void showInfor(){
         System.out.println("姓名："+name+" 年龄："+age+" 得分："+score);
     }
 }
