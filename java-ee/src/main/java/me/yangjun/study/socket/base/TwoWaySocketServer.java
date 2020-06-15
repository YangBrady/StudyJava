package me.yangjun.study.socket.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 双通信 - 服务端
 *
 * @author mooejun
 * @since 2019/12/13
 */
public class TwoWaySocketServer {
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;

	private void runServerSingle() throws IOException {
		this.serverSocket = new ServerSocket(9001);
		this.socket = serverSocket.accept();

		is = this.socket.getInputStream();
		byte[] readBytes = new byte[1024];
		int msgLen;
		StringBuilder stringBuilder = new StringBuilder();
		while ((msgLen = is.read(readBytes)) != -1) {
			stringBuilder.append(new String(readBytes, 0, msgLen, StandardCharsets.UTF_8));
		}
		String msg = stringBuilder.toString();
		System.out.println("[Server]接收:" + msg);

		// 告诉客户端接收完毕， 之后只能发送 InputStream关闭了
		this.socket.shutdownInput();

		this.os = this.socket.getOutputStream();
		String receipt = "ok";
		os.write(receipt.getBytes(StandardCharsets.UTF_8));

		//is.close();
		os.close();
		socket.close();
		serverSocket.close();
	}

	public static void main(String[] args) {
		TwoWaySocketServer bs = new TwoWaySocketServer();
		try {
			bs.runServerSingle();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
