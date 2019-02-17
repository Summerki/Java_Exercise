package cn.suki.io;

import java.io.*;

/**
 * @author summerki
 */
public class IOTest01 {
    public static void main(String[] args) {
        // 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 选择流
        try {
            InputStream is = new FileInputStream(src);
            // 3、操作
            int data1 = is.read();// 第一个数据 s
            int data2 = is.read(); // x
            int data3 = is.read(); // t
            int data4 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println(data4); // 文件末尾返回-1
            // 4、释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
