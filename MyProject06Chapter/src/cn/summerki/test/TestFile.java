package cn.summerki.test;

import java.io.File;
import java.io.IOException;

/**
 * 测试文件操作
 * @author summerki
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        File f = new File("test.txt");
//        f.createNewFile();
        f.getAbsoluteFile();
    }
}
