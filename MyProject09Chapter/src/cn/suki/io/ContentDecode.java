package cn.suki.io;

import java.io.UnsupportedEncodingException;

/**
 * @author summerki
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "性命 生命 使命";
        // 编码->为了获得字节数组
        byte[] datas = msg.getBytes();
        System.out.println(datas.length); // 输出20 因为utf-8中一个中文占3个字节，空格占一个字节

        // 解码：字节-》字符
        msg = new String(datas, 0, datas.length, "utf8");
        System.out.println(msg);


        // 乱码原因
        // 1、字节数不够
        msg = new String(datas, 0, datas.length - 2, "utf-8");
        System.out.println(msg);
        // 2、字符集不统一
        msg = new String(datas, 0, datas.length, "gbk");
        System.out.println(msg);
    }




}
