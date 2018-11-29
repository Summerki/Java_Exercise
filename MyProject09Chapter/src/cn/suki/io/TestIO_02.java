package cn.suki.io;

import java.io.*;

public class TestIO_02 {
    public static void main(String[] args) throws IOException {
        // 创建源
        String path = System.getProperty("user.dir");
        String pathDestination = path + "/abc.txt";
        File f = new File(pathDestination);

        // 选择流
        InputStream is = new FileInputStream(f);

        // 操作
        int data1 = is.read();
        int data2 = is.read();
        int data3 = is.read();

        System.out.println((char) data1);
        System.out.println((char) data2);
        System.out.println((char)data3);

        // 关闭流
        if(f != null){
            is.close();
        }

    }
}
