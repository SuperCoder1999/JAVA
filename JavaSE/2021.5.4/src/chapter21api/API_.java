package chapter21api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    InetAddress作用：
    1. 在电脑中获取本机的信息【主机名、IP】
    2. 通过域名获取远程服务器的IP
 */

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //1. 获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//AppleTree/192.168.31.1

        //2. 根据指定主机名 获取 InetAddress 对象
        InetAddress host1 = InetAddress.getByName("AppleTree");
        System.out.println(host1);

        //3. 根据域名返回 InetAddress对象，比如 www.baidu.com 对应的
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2 = " + host2);

        //4. 通过InetAddress 对象， 获取对应地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2 Address = " + hostAddress);

        //5. 通过InetAddress 对象，获取对应的主机名或者 域名
        String hostName = host2.getHostName();
        System.out.println("host2 Name = " + hostName);
    }
}
