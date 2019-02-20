package cn.suki.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author summerki
 */
public class IOTest08 {
    public static void main(String[] args) {
        // 1 确定源
        byte[] dest = null;
        // 2 选择流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 3 操作
        String msg = "show me the code";
        byte[] datas = msg.getBytes();
        baos.write(datas,0,datas.length);
        try {
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取数据
        dest = baos.toByteArray();
        System.out.println(dest.length + "--->" + new String(dest,0,baos.size()));
    }
}
