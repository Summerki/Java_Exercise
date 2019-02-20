package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class FileDemo04 {
    public static void main(String[] args) {
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.png");

        System.out.println("是否存在" + src.exists());
        System.out.println("是否是文件" + src.isFile());
        System.out.println("是否是文件夹" + src.isDirectory());
    }
}
