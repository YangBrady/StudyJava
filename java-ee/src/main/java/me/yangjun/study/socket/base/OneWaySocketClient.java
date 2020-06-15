package me.yangjun.study.socket.base;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 单向通信 - 客户端
 *
 * @author mooejun
 * @since 2019/12/13
 */
public class OneWaySocketClient {
	private Socket socket;
	private OutputStream os;

	private void connetServer() throws IOException {
		this.socket = new Socket("", 9001);
		this.os = socket.getOutputStream();
	}

	private void sendSingle(String msg) throws IOException {
		this.os.write(msg.getBytes("utf-8"));
		this.os.close();
		this.socket.close();
	}

	public static void main(String[] args) {
		OneWaySocketClient bc = new OneWaySocketClient();
		try {
			bc.connetServer();
			bc.sendSingle("哈哈");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
