package me.yangjun.modules.base.多线程.demo.demo002;

import lombok.Data;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author mooejun
 * @since 2020/04/20
 */
@Data
public class SaveProcessor extends Thread implements Processor {
	private LinkedBlockingQueue<MyRequest> queue = new LinkedBlockingQueue<>();

	@Override
	public void processorRequest(MyRequest request) {
		queue.add(request);
	}

	@Override
	public void run() {
		System.out.println("SaveProcessor start");
		while (true) {
			try {
				MyRequest request = queue.take();
				System.out.println("save data: " + request.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("SaveProcessor end");
	}
}
