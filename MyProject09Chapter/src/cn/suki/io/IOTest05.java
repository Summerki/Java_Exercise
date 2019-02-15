package cn.suki.io;

import java.io.*;

/**
 * @author summerki
 */
public class IOTest05 {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 2 选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            // 3 操作（分段读取）
            char[] flush = new char[1024]; // 缓冲容器
            int len = -1; // 接受长度
            while((len = reader.read(flush)) != -1){
                // 字符数组->字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4 释放资源
        try {
            if(reader != null){
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
