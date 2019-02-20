package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class FileDemo03 {
    public static void main(String[] args) {
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.png");

        System.out.println("名称" + src.getName());
        System.out.println("路径" + src.getPath()); // 给你什么路径就返回什么路径
        System.out.println("绝对路径" + src.getAbsolutePath());

        System.out.println("父路径" + src.getParent());

        System.out.println("父路径对象的名称" + src.getParentFile().getName());
    }
}
