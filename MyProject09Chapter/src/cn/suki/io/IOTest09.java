package cn.suki.io;


import java.io.*;
import java.util.zip.InflaterOutputStream;

/**
 * @author summerki
 */
public class IOTest09 {
    public static void main(String[] args) {
        byte[] datas = FileToByteArray("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.png");
        System.out.println(datas.length);
        ByteArrayToFile(datas,"ByteArrayToFile.png");
    }

    /**
     * 图片读取到字节数组
     * 第一步：图片到程序 FileInputStream
     * 第二步：程序到字节数组 ByteArrayOutputStream
     */
    public static byte[] FileToByteArray(String filePath){

        // 1 创建源头与目的地
        File src = new File(filePath);
        byte[] dest = null;
        // 2 选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            // 3 操作（分段读取）
            byte[] flush = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                baos.write(flush,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 4 释放资源
        try {
            if(is != null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字节数组写出到图片
     * 第一步:字节数组读取到程序 ByteArrayInputStream
     * 第二步：程序写出到文件 FileOutputStream
     */
    public static void ByteArrayToFile(byte[] src, String filePath){
        // 1 确定源
        File dest = new File(filePath);
        // 2 选择流
        InputStream is = null;
        FileOutputStream os = null;
        try {
            is = new ByteArrayInputStream(src);
            os = new FileOutputStream(dest);
            // 3 操作（分段写出）
            byte[] flush = new byte[5];
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
        try {
            if(os != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
