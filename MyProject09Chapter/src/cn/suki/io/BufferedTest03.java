package cn.suki.io;

import java.io.*;

/**
 * @author Summerki
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 2 选择流
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            // 3 操作
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
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
