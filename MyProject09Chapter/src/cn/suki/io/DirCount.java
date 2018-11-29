package cn.suki.io;

import java.io.File;
import java.util.concurrent.CountDownLatch;

/**
 * 使用面向对象的方法实现统计文件夹的代大小
 */
public class DirCount {
    //大小
    private long len;

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }

    // 文件夹的路径
    private String dirPath;

    // 源
    private File src;

    public DirCount(String dirPath){
        this.dirPath = dirPath;
        this.src = new File(dirPath);
        count(this.src);
    }

    public static void main(String[] args) {
        String workPath = System.getProperty("user.dir");
        DirCount dir = new DirCount(workPath);
        System.out.println(dir.getLen());
    }

    private void count(File src){
        // 获取大小
        if(src != null && src.exists()){
            if(src.isFile()){
                len += src.length();
            }else{ // 子孙级
                for(File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }
}
