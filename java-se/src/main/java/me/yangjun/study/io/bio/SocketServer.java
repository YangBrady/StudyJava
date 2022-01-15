package me.yangjun.study.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO服务端源码
 *
 * @author mooejun
 * @since 2022/1/15 15:51
 */

public class SocketServer {
	private static ServerSocket server;
	public static String IP = "127.0.0.1";
	public static int PORT = 9000;
	public static ExecutorService executorService = Executors.newFixedThreadPool(5);

	public static void start() throws IOException {
		try {
			server = new ServerSocket(PORT);
			System.out.println("服务启动成功");
			while (true) {
				// 没有连接的话会一直阻塞在这里
				Socket socket = server.accept();
				System.out.println("检测到新连接");
				executorService.execute(new ServerHandle(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (server != null) {
				server.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		start();
	}
}
