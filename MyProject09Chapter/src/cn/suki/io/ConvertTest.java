package cn.suki.io;

import java.io.*;

/**
 * @author Summerki
 */
public class ConvertTest {
    public static void main(String[] args) {
        // 操作system.in 和 system.out
//        InputStreamReader isr = new InputStreamReader(System.in);
//        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        // 将上面加入Buffered改成：
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));){
            // 循环获取键盘的输入（exit退出），输出此内容
            String msg = "";
            while (!msg.equals("exit")){
                msg = reader.readLine();// 循环读取
                writer.write(msg);// 循环写出
                writer.newLine();
                writer.flush();// 强制刷新
            }
        }catch (Exception e){
            System.out.println("操作异常");
        }
    }
}
