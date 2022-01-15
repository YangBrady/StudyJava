package me.yangjun.study.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author mooejun
 * @since 2022/1/15 16:49
 */
public class ServerHandle implements Runnable {
	private Socket socket;

	ServerHandle(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			String message;
			String result;
			while ((message = reader.readLine()) != null) {
				System.out.println("服务器收到数据：" + message);
				writer.println(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				socket = null;
			}
		}
	}

}
