package me.yangjun.study.socket.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单向通信 - 服务端
 *
 * @author mooejun
 * @since 2019/12/13
 */
public class OneWaySocketServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;

	private void runServerSingle() throws IOException {
		this.serverSocket = new ServerSocket(9001);
		this.socket = serverSocket.accept();

		is = this.socket.getInputStream();
		byte[] readBytes = new byte[1024];
		int msgLen;
		StringBuilder stringBuilder = new StringBuilder();
		while ((msgLen = is.read(readBytes)) != -1) {
			stringBuilder.append(new String(readBytes, 0, msgLen, "utf-8"));
		}
		System.out.println("result=" + stringBuilder.toString());

		is.close();
		socket.close();
		serverSocket.close();
	}

	public static void main(String[] args) {
		OneWaySocketServer bs = new OneWaySocketServer();
		try {
			bs.runServerSingle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
