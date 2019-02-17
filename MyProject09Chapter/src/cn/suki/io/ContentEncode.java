package cn.suki.io;

/**
 * 编码：字符-》字节
 * @author summerki
 */
public class ContentEncode {
    public static void main(String[] args) {
        String msg = "性命 生命 使命";
        // 编码->为了获得字节数组
        byte[] datas = msg.getBytes();
        System.out.println(datas.length); // 输出20 因为utf-8中一个中文占3个字节，空格占一个字节
    }
}
