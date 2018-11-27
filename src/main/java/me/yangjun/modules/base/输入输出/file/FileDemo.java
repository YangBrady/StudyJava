package me.yangjun.modules.base.输入输出.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileDemo {

	@Test
	public void testProp() {
		System.out.println("pathSeparator = " + File.pathSeparator);
		System.out.println("separator = " + String.valueOf(File.separator));
	}

	@Test
	public void testCreateFile() {
		File file = new File("src" + File.separator + "main" + File.separator + "java" + File.separator + "me"
				+ File.separator + "yangjun" + File.separator + "modules" + File.separator + "base" + File.separator
				+ "输入输出" + File.separator + "file" + File.separator + "CreateNewFile01.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
