1. 系统字体设置：File--settings--Appearance & Behavior--Appearance
2. 代码框字体大小设置：File--settings--Editor--Font
3. 代码框字体加粗设置：File--settings--Editor--Color Scheme--General--Text--Default text勾选Bold
4. 主题切换：File--settings--Editor--Color Scheme--Scheme
5. 编码设置
6. 双击.java标签，可以隐藏资源管理器
7. 模板：main/psvm都能调用main模板

一： 快捷键（https://blog.csdn.net/xinghuo0007/article/details/78441574）
    也可在 Keymap 中搜索
1. 删除行：Ctrl + Y
2. 复制当前行：（Duplicate） 将光标放在默认所在行 Ctrl+c 即可
3. 补全代码：alt + /
4. 添加注释：Ctrl + / 或者 Ctrl + shift + / 添加 /*
5. 快速导入类：File--settings--Editor--General--Auto import 或者快捷键 Alt + Enter
6. 快速格式化（reform）：Ctrl + alt + L
7. 生成构造器/生成测试类：alt + insert
8. 查看类的层级关系（Diagrams） ： 光标放在类名上，Ctrl + H ，看类的继承关系
9. 光标放在一个方法上，Ctrl + b、Ctrl+左键 ，可以定位到该方法(类)的定义区域（继承中很好用）(也可以用来看JDK源码）
10. 自动分配变量名：new Scanner(System_.in).var回车
11  alt + enter:自动添加类的包
12. 10000.for 就会创建10000次循环的for循环 同样的 items.for 也可以
13. try-catch处理异常：将该代码块->选中->快捷键 ctrl + alt + t -> 选中 try-catch
14. 在接口或方法处CTRL+alt+b   查看实现或重写该接口或方法的类或者找子类
15. 显示所有的快捷模板的的快捷键 ctrl + j
16. 快捷模板键，快速生成 while (iterator.hasNext()) => itit Iterator迭代器
17. 快捷模板键 I   快速生成 for (Object book : col){} 增强for循环
18. 将字符串输出："hello".sout 即可
19. setting - Build,Execution,Deployment -
Debugger - Java - Enable alternative view for Collections classes在Debugger时可以显示全部集合元素
20. 查找文件 shift+shift 在需要测试的类中 ctrl+shift+t  再选择其他包,即可创建一个测试类
21. 替换所有 文字 Ctrl+r
22. 显示当前类/接口 被谁实现或继承 Ctrl+H 调取Hierarchy
23. 快速测试:ctrl+shift+t
24. 快速替换:ctrl+shift+r 可以替换多个文件或特定文件(看尚硅谷10.书城项目)
25. 查看一个方法的形参: ctrl+P
26. 打开Structure: alt+7
27. 复制到下一行:ctrl+D
28. 查看方法: ctrl+F12(至于怎么在这个窗口中查找特定的方法不清楚)
29. 变成大写:ctrl+shift+U
30. 快速重写:ctrl+o
31. 在类中查找方法:ctrl+F12
32. 看接口的可以重写的方法: Ctrl+O

二：模板（File--Settings--Editor--Live templates,选择范围java）
1. main回车
2. sout回车
3. fori回车
4. 输入CD按Tab/回车即可出来CDATA节


三：现实形参的参数名
("Jack", 180, 20000)
    File--Settings--Editor--Inlay Hints--Java--Show parameter hints for

四：起始模板
1. setting - edit - file and code... - include

五：关于jdk指令
```
javac Hello.java - 编译
java Hello - 运行
javap Hello.class -反编译,将.class文件变成.java文件
```
    
六: 使用技巧
1. 从外部复制代码,可以不用创建类文件.如果代码中带有public class <类名>.则会直接创建该类名的java文件
2. 通过maven导入的依赖包.源码(带注解的,Idea反编译的源码不带注解)可以通过DownloadSources获取,而自己导入的jar包应该找不到下载源,所以只能通过手动添加源代码