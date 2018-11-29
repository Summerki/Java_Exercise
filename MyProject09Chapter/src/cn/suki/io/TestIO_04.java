package cn.suki.io;

import javax.sql.DataSource;
import java.io.*;

/**
 * 分段读取操作
 */
public class TestIO_04 {
    public static void main(String[] args) {
        String path = "abc.txt";
        // 创建源
        File f = new File(path);

        // 选择流
        InputStream is;
        try {
            is = new FileInputStream(f);
            // 分段读取
            byte[] car = new byte[3];
            int len = -1;
            while((len = is.read(car)) != -1){
                String str = new String(car, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
