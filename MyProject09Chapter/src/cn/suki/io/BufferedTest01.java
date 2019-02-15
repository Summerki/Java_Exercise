package cn.suki.io;

import java.io.*;

/**
 * @author Summerki
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        // 1 确定源
        File src = new File("IO.txt");
        // 2 选择流
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            // 3 操作（分段读取）
            byte[] flush = new byte[1024];
            int len = -1;
            while((len = is.read(flush)) != -1){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(is != null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
