package cn.suki.io;

import java.io.*;

/**
 * @author Summerki
 */
public class FileUtils {
    public static void main(String[] args) {
        // 文件到文件
        try {
            InputStream is = new FileInputStream("IO.txt");
            OutputStream os = new FileOutputStream("IO-copy.txt");
            Copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("IO.png");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("IO-copy-2.png");
            Copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对接输入输出流
     * @param is
     * @param os
     */
    public static void Copy(InputStream is, OutputStream os){
        try {
            // 3 操作（分段读取）
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4 释放资源
        Close(is,os);
    }

    /**
     * 释放资源
     */
    public static void Close(InputStream is, OutputStream os){
        try {
            if(is != null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(os != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源，这个无论你有多少个流都可以关闭
     * 形式参数中的...代表可变参数
     * @param ios
     */
    public static void Close(Closeable... ios){
        for(Closeable io : ios){
            try {
                if(io != null){
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
