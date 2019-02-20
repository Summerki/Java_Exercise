package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class FileDemo01 {
    public static void main(String[] args) {
        String path = "E:/1-Java-Exercise/Java_Exercise/MyProject09Chapter/IO.png";

        // 1、构建file对象)
        File src = new File(path);
        System.out.println(src.length());

        // 2、构建file对象
        src = new File("E:/1-Java-Exercise/Java_Exercise/MyProject09Chapter", "IO.png");
        System.out.println(src.length());

        // 3、 构建file对象
        src = new File(new File("E:/1-Java-Exercise/Java_Exercise/MyProject09Chapter"), "IO.png");
        System.out.println(src.length());
    }
}
