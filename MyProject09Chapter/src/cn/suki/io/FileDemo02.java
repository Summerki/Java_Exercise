package cn.suki.io;

import java.io.File;
import java.io.IOException;

public class FileDemo02 {
    public static void main(String[] args) throws IOException {
        File src = new File("aaa/io.jpg");
        System.out.println(src.getParentFile().getName());

        String path = System.getProperty("user.dir");
        System.out.println(path);

        File src02 = new File(path + "/io.txt");
        boolean bCreate = src02.createNewFile();
        if(bCreate){
            System.out.println("文件创建成功");
        }else{
            System.out.println("文件创建失败");
        }

        File dir = new File(path);
        String[] dirs = dir.list();
        for(String f:dirs){
            System.out.println(f);
        }
    }
}
