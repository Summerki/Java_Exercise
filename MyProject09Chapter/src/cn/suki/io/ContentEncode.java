package cn.suki.io;

import java.io.UnsupportedEncodingException;

/**
 * 字符串到字节：编码
 */
public class ContentEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "测试";
        byte[] datas = msg.getBytes(); // 默认使用工程的字符集
        System.out.println(datas.length); // 说明一个汉字占3个字节

        datas = msg.getBytes("UTF-16LE"); // 说明在这种编码格式下一个汉字占2个字节
        System.out.println(datas.length);

        datas = msg.getBytes("GBK");
        System.out.println(datas.length);
    }
}
