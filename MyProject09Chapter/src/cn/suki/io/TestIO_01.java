package cn.suki.io;

import sun.security.util.AuthResources_it;

import java.io.File;
import java.io.IOException;

public class TestIO_01 {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        File src = new File(path + "/abc.txt");
        src.createNewFile();
    }
}
