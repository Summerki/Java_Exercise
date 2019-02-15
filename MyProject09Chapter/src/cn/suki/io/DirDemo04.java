package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter");
        printName(src,0);
    }

    public static void printName(File src, int deep){
        System.out.println(src.getName());
        for(int i = 0; i < deep ; i++){
            System.out.print("-");
        }
        if(null == src || !src.exists()){
            return;
        }else if(src.isDirectory()){
            for(File s : src.listFiles()){
                printName(s,deep + 1);
            }
        }
    }
}
