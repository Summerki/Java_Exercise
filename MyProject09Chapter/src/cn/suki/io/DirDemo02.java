package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class DirDemo02 {
    public static void main(String[] args) {
        // 列出下级名称
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter");

        String[] subNames = src.list();
        for(String s : subNames){
            System.out.println(s);
        }

        // 获取file对象
        File[] subFiles = src.listFiles();
        for(File f : subFiles){
            System.out.println(f.getAbsolutePath());
        }

        // 列出所有的盘符
        File[] roots = src.listRoots();
        for(File root : roots){
            System.out.println(root);
        }
    }
}
