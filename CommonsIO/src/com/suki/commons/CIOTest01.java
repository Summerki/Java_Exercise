package com.suki.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Summerki
 */
public class CIOTest01 {
    public static void main(String[] args) throws IOException {
        // 文件大小
        long len = FileUtils.sizeOf(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO\\IO.txt"));
        System.out.println(len);
        // 目录大小
        len = FileUtils.sizeOf(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO\\lib"));
        System.out.println(len);

        // 列出子孙级  以下只操作一层目录
//        Collection<File> files = FileUtils.listFiles(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO"), EmptyFileFilter.NOT_EMPTY,DirectoryFileFilter.INSTANCE);
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }

        // 列出子孙级 以下可以显示子孙级
//        Collection<File> files = FileUtils.listFiles(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO"), EmptyFileFilter.NOT_EMPTY,DirectoryFileFilter.INSTANCE);
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }

        // 列出子孙级，但是只看特定的文件后缀名
        // 仅看.java文件
//        Collection<File> files = FileUtils.listFiles(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO"),new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
//        for(File file : files){
//            System.out.println(file.getAbsolutePath());
//        }

        // 仅看.java和.class文件
        Collection<File> files = FileUtils.listFiles(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO"), FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class")),DirectoryFileFilter.INSTANCE);
        for(File file : files){
            System.out.println(file.getAbsolutePath());
        }


        // 读取文件
        String msg = FileUtils.readFileToString(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO\\IO.txt"),"UTF-8");
        System.out.println(msg);
        // 也可以将内容读到字节数组之中
        byte[] datas = FileUtils.readFileToByteArray(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO\\IO.txt"));
        System.out.println(datas.length);

        // 逐行读取
        List<String> msgs = FileUtils.readLines(new File("E:\\1-Java-Exercise\\Java_Exercise\\CommonsIO\\IO.txt"),"UTF-8");
        for(String str : msgs){
            System.out.println(str);
        }
        // 还提供了迭代器逐行读取
        LineIterator it = FileUtils.lineIterator(new File("IO.txt"),"UTF-8");
        while(it.hasNext()){
            System.out.println(it.nextLine());
        }



        // 写出内容
        FileUtils.write(new File("IOIO.txt"), "测试write", "UTF-8",true);
        FileUtils.writeStringToFile(new File("IOIO.txt"), "测试write", "UTF-8",true);
        FileUtils.writeByteArrayToFile(new File("IOIO.txt"), "测试write".getBytes("UTF-8"), true);
        // 写出列表
        List<String> listDatas = new ArrayList<String>();
        listDatas.add("马云");
        listDatas.add("马yun");
        listDatas.add("马-云");
        FileUtils.writeLines(new File("IOIO.txt"),listDatas,"...",true);


        // 拷贝
        FileUtils.copyFile(new File("IO.txt"),new File("IO-copy.txt"));
        // 复制文件到目录
        FileUtils.copyFileToDirectory(new File("IO.txt"),new File("lib"));
        // 复制目录到目录
        FileUtils.copyDirectoryToDirectory(new File("out"),new File("lib"));
        // 复制目录
        FileUtils.copyDirectory(new File("lib"), new File("lib2"));

        // 拷贝URL内容
        String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1547449146&di=f8877b0c35b55ef7ba7dc3bfa460843a&src=http://www.czlzcm.com/Upload/1444623144.png";
        FileUtils.copyURLToFile(new URL(url), new File("pic.jpg"));
        // 网站源代码
        String data = IOUtils.toString(new URL("http://www.baidu.com"),"UTF-8");
        System.out.println(data);
    }
}
