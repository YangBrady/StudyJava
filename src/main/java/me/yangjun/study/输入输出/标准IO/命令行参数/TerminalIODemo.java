package me.yangjun.study.输入输出.标准IO.命令行参数;

public class TerminalIODemo {
	public static void main(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		}
	}
}
