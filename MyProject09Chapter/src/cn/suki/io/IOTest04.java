package cn.suki.io;

import java.io.*;

/**
 * @author summerki
 */
public class IOTest04 {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\dest.txt");
        // 2 选择流
        OutputStream os = null;
        try {
            os = new FileOutputStream(src,true); // 可以选择往指定文件里面追加或是覆盖
            // 3 操作（写出）
            String msg = "IO is so easy";
            byte[] datas = msg.getBytes(); // 字符串->字节数组(编码)
            os.write(datas,0,datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(os != null){
                // 4 释放资源
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
