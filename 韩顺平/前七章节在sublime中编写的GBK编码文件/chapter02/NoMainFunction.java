//测试没有main方法还能运行不
//
//答案:不能
//错误: 在类 Dog2 中找不到 main 方法, 请将 main 方法定义为:
 //  public static void main(String[] args)
 //否则 JavaFX 应用程序类必须扩展javafx.application.Application
class Dog2 {
	public  void func() {
		System.out.println("hello, 小狗狗~");
	}
}