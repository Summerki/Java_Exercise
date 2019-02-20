package cn.suki.io;

import java.io.File;
import java.io.IOException;

/**
 * @author summerki
 */
public class FileDemo06 {
    public static void main(String[] args) throws IOException {
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        boolean flag = src.createNewFile();
        System.out.println(flag);
    }
}
