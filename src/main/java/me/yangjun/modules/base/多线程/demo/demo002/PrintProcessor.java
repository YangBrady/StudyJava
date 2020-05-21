package me.yangjun.modules.base.多线程.demo.demo002;

import lombok.Data;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author mooejun
 * @since 2020/04/20
 */
@Data
public class PrintProcessor extends Thread implements Processor {
	private LinkedBlockingQueue<MyRequest> queue = new LinkedBlockingQueue<>();
	private final Processor nextProcessor;

	public PrintProcessor(Processor nextProcessor) {
		this.nextProcessor = nextProcessor;
	}

	@Override
	public void processorRequest(MyRequest request) {
		queue.add(request);
	}

	@Override
	public void run() {
		while (true) {
			try {
				MyRequest request = queue.take();
				System.out.println("print data: " + request.getName());
				nextProcessor.processorRequest(request);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
