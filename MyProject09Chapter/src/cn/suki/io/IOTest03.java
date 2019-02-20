package cn.suki.io;

import java.io.*;

/**
 * @author summerki
 */
public class IOTest03 {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 2 选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            // 3 操作(分段读取)
            byte[] car = new byte[3]; // 缓冲容器
            int len = -1; // 接收长度
            while ((len = is.read(car)) != -1){
                // 字节数组还原成字符串（解码）
                String str = new String(car, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
