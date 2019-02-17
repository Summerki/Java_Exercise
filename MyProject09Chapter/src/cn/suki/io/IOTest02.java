package cn.suki.io;

import java.io.*;

/**
 * @author summerki
 */
public class IOTest02 {
    public static void main(String[] args) {
        // 1、确定源
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 2、选择流
        InputStream is = null;
        try {
             is = new FileInputStream(src);
            // 3、操作（读取）
            int temp;
            while((temp = is.read()) != -1){
                System.out.println((char)temp);
            }
            // 4、释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(is != null){ // 确定流不为空才关闭
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
