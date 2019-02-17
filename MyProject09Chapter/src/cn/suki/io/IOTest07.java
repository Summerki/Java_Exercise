package cn.suki.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author summerki
 */
public class IOTest07 {
    public static void main(String[] args) {
        // 1 确定源(这里不再是file对象了，直接是字节数组对象)
        byte[] src = "talk is cheap show me the code".getBytes();
        // 2 选择流
        InputStream is = new ByteArrayInputStream(src);
        // 3 操作
        byte[] flush = new byte[5];
        int len = -1;
        while(true){
            try {
                if (!((len = is.read(flush)) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = new String(flush,0,len);
            System.out.println(str);
        }
    }
}
