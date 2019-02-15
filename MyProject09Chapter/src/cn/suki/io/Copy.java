package cn.suki.io;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * @author summerki
 */
public class Copy {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");// 源头
        File dest = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\dest.txt"); // 目的地
        // 2 选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            // 3 操作（读取和写入）
            // 分段读取
            byte[] flush = new byte[1024];
            int len = -1;
            while((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4 释放资源 分别关闭 先打开的后关闭
        try {
            if(os != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(is != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
