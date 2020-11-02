package me.yangjun.study.网络编程;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {
	public static void main(String[] args) {

		Constants echo = new Constants();
		echo.doEcho();
	}

	public void showInetAddress() {
		try {
			// 使用域名创建对象
			InetAddress inet1 = InetAddress.getByName("www.163.com");
			System.out.println(inet1); // www.163.com/14.215.9.84

			// 使用IP创建对象
			InetAddress inet2 = InetAddress.getByName("127.0.0.1");
			System.out.println(inet2); // /127.0.0.1

			// 获取本机地址对象
			InetAddress inet3 = InetAddress.getLocalHost();
			System.out.println(inet3); // A23139164_03/10.9.235.74

			// 获取对象中存储的IP
			String ip = inet3.getHostAddress();
			System.out.println("IP:" + ip); // IP:10.9.235.74
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Constants {
	public void doEcho() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		// 监听端口号
		int port = 10000;
		try {
			// 建立连接
			serverSocket = new ServerSocket(port);
			// 获得连接
			socket = serverSocket.accept();
			// 接收客户端发送内容
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);
			// 输出
			System.out.println("客户端发送内容为：" + new String(b, 0, n));
			// 向客户端发送反馈内容
			os = socket.getOutputStream();
			os.write(b, 0, n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流和连接
				os.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (Exception e) {
			}
		}
	}
}