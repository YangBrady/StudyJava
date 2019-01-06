package me.yangjun.modules.base.输入输出.测验;

import org.junit.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by 杨峻 on 2016/10/20.
 */
public class TestDemo {

    /**
     * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.txt文件中用回车或空格进行分隔。
     */
    @Test
    public void testDemo001() {
        File file = new File("src/main/java/me/yangjun/modules/base/输入输出/测验/001_c.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);) {
            FileInputStream fileInputStreamA = new FileInputStream("src/main/java/me/yangjun/modules/base/输入输出/测验/001_a.txt");
            FileInputStream fileInputStreamB = new FileInputStream("src/main/java/me/yangjun/modules/base/输入输出/测验/001_b.txt");

            byte[] cacheByte = new byte[1024];
            int readInt = 0;
            while ((readInt = fileInputStreamA.read()) != -1) {
                fileOutputStream.write(readInt);
            }
            fileOutputStream.write(System.getProperty("line.separator").getBytes());
            while ((readInt = fileInputStreamB.read()) != -1) {
                fileOutputStream.write(readInt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
