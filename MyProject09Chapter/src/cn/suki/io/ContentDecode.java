package cn.suki.io;

import java.io.UnsupportedEncodingException;

public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "测试";
        byte[] datas = msg.getBytes();

        // 解码
        msg = new String(datas, 0, datas.length, "utf-8");
        System.out.println(msg);
    }
}
