package me.yangjun.study.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端线程
 *
 * @author mooejun
 * @since 2022/1/15 15:54
 */
public class SocketClient {
	public static String IP = "127.0.0.1";
	public static int PORT = 9000;

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(IP, PORT);

			System.out.println("请输入数据");
			new ReadMsg(socket).start();

			while (true) {
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(new Scanner(System.in).next());
				System.out.print("服务器返回数据：");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static class ReadMsg extends Thread {
		private Socket socket;

		ReadMsg(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = null;
				while ((line = reader1.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				clear();
			}
		}

		//必要的资源清理工作
		private void clear() {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
