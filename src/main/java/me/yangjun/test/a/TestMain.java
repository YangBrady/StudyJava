package me.yangjun.test.a;

import java.net.URL;

/**
 * Created by 杨峻 on 2016/9/20. class.getResource() 与
 * class.getClassLoader().getResource() 方法
 */
public class TestMain {

	public static void main(String[] args) {
		TestGetResource a = new TestGetResource();
		// a.show();

		GetClassLoader b = new GetClassLoader();
		b.show();
	}
}

class TestGetResource {
	public void show() {
		// TestMain.class在<bin>/me/testPackage包中

		// class path根目录
		System.out.println(TestMain.class.getResource("/"));
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/

		// 当前类(class)所在的包目录
		System.out.println(TestMain.class.getResource(""));
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/me/testPackage/a/

		// 1.txt 在bin/me/testPackage
		System.out.println(TestMain.class.getResource("/me/testPackage/1.txt"));
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/me/testPackage/1.txt

		// 2.txt 在<bin>/me/testPackage/a包中
		System.out.println(TestMain.class.getResource("2.txt"));
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/me/testPackage/a/2.txt

		// 3.txt 在<bin>/me/testPackage/a/aa包中
		System.out.println(TestMain.class.getResource("aa/3.txt"));
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/me/testPackage/a/aa/3.txt

	}
}

class GetClassLoader {
	public void show() {
		System.out.println(TestMain.class.getClassLoader().getResource(""));
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/
		// class.getClassLoader().getResource("") 方法 和 class.getResource("/")
		// 返回的结果是一样的，都是返回当前类所在的包目录

		URL url = TestMain.class.getClassLoader().getResource("me/testPackage/a/aa/3.txt");
		System.out.println(url);
		// file:/D:/yangjun/WorkSpaces/IntelliJ/JavaDemo/out/production/JavaDemo/me/testPackage/a/aa/3.txt
	}
}