package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\dir\\test");

        // 创建目录
        boolean flag = dir.mkdirs();
        System.out.println(flag);

    }
}
