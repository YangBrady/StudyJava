package me.yangjun.modules.base.多线程.demo.demo002;

/**
 * @author mooejun
 * @since 2020/04/20
 */
public class Demo {

	private PrintProcessor printProcessor;

	public Demo() {
		SaveProcessor saveProcessor = new SaveProcessor();
		saveProcessor.start();

		printProcessor = new PrintProcessor(saveProcessor);
		printProcessor.start();
	}

	public static void main(String[] args) {
		MyRequest myRequest = new MyRequest();
		myRequest.setName("haha");
		new Demo().show(myRequest);
	}

	public void show(MyRequest myRequest) {
		printProcessor.processorRequest(myRequest);
	}
}
