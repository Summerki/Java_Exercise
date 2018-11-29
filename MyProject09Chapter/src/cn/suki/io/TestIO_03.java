package cn.suki.io;

import java.io.*;

/**
 * 读取一个文件的所有东西
 */
public class TestIO_03 {
    public static void main(String[] args){
        // 创建源
        String path = "abc.txt";
        File f = new File(path);

        InputStream is = null;
        // 选择流
        try {
            is = new FileInputStream(f);
            // 读取
            int temp;
            while((temp = is.read()) != -1){
                System.out.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            try{
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
