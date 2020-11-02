package me.yangjun.study.输入输出.测试;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class TestDemo {
    @Test
    public void function1() throws IOException {
        //Scanner in = new Scanner(System.in); //从输入参数读取
        Scanner in = new Scanner(Paths.get("src/me/输入输出/1.txt")); //从文件读取
        //Scanner in = new Scanner(Paths.get("c:\\mydirectory\\myfile.txt"));
        String line;
        while (in.hasNext()) {
            line = in.nextLine();
            System.out.println(line);
        }

        //PrintWriter out = new PrintWriter("src/me/输入输出/out.txt");
    }
}
