package me.yangjun.modules.baseweb.socket.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 双通信 - 服务端
 *
 * @author mooejun
 * @since 2019/12/13
 */
public class TwoWaySocketClient {
	private Socket socket;
	private InputStream is;
	private OutputStream os;

	private void connetServer() throws IOException {
		this.socket = new Socket("127.0.0.1", 9001);
		this.os = socket.getOutputStream();
	}

	private void sendMsg(String msg) throws IOException {
		this.os.write(msg.getBytes(StandardCharsets.UTF_8));
		this.socket.shutdownOutput();// 告诉服务器，所有的发送动作已经结束，之后只能接收

		this.is = this.socket.getInputStream();
		byte[] readBytes = new byte[1024];
		int msgLen;
		StringBuilder stringBuilder = new StringBuilder();
		while ((msgLen = is.read(readBytes)) != -1) {
			stringBuilder.append(new String(readBytes, 0, msgLen, StandardCharsets.UTF_8));
		}
		String receipt = stringBuilder.toString();
		System.out.println("[Client]收到: " + receipt);

		this.os.close();
		this.is.close();
		this.socket.close();
	}

	public static void main(String[] args) {
		TwoWaySocketClient bc = new TwoWaySocketClient();
		try {
			bc.connetServer();
			bc.sendMsg("哈哈");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
