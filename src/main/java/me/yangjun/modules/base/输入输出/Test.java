package me.yangjun.modules.base.输入输出;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by 杨峻 on 2016/10/20.
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();

        try {
            t.function1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void function1() throws IOException {
        //Scanner in = new Scanner(System.in); //从输入参数读取
        Scanner in = new Scanner(Paths.get("src/me/输入输出/1.txt")); //从文件读取
        //Scanner in = new Scanner(Paths.get("c:\\mydirectory\\myfile.txt"));
        String line;
        while(in.hasNext()){
            line = in.nextLine();
            System.out.println(line);
        }


        //PrintWriter out = new PrintWriter("src/me/输入输出/out.txt");
    }
}
