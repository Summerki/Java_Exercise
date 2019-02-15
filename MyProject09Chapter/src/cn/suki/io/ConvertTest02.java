package cn.suki.io;

import java.io.*;
import java.net.URL;

/**
 * @author Summerki
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        // 操作网络流 下载百度的源代码（爬虫）
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new URL("http://www.baidu.com").openStream(),"UTF-8"));
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("baidu.html"),"UTF-8"));
        ){
            // openStream是一个节点流，也是一个字节流

            // 操作
            String msg;
            while ((msg = reader.readLine()) != null){
                System.out.println(msg);
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        }catch (Exception e){
            System.out.println("操作异常");
        }
    }
}
