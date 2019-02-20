package cn.suki.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author summerki
 */
public class IOTest06 {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 2 选择流
        Writer writer = null;
        try {
            writer = new FileWriter(src);
            // 3 操作
            // 方法1
            String msg = "IO is so easy!";
            char[] datas = msg.toCharArray();// 字符串->字符数组
            writer.write(datas,0,datas.length);
            writer.flush();
            // 方法2:直接使用字符串
            writer.write(msg);
            writer.flush();
            // 方法3：使用append
            writer.append("IO is so easy").append("IO is so easy");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4 释放资源
        try {
            if(writer != null){
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
