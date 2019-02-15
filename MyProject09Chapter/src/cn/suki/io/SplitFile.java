package cn.suki.io;

import com.sun.org.apache.xml.internal.security.Init;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Summerki
 */
public class SplitFile {
    // 源头
    private File src;
    // 目的地(文件夹)
    private String destDir;
    // 所有分割后的文件存储路径
    private List<String> destPaths;
    // 每块大小
    private int blockSize;
    // 块数：多少块
    private int size;

    public SplitFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();

        // 初始化
        Init();
    }

    // 初始化
    private void Init(){
        // 总长度
        long len = this.src.length();
        // 块数：多少块
        this.size = (int)Math.ceil(len * 1.0 / blockSize);
        // 路径
        for (int i = 0; i < size; i++){
            this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
        }
    }

    /**
     * 分割
     * 1、计算每一块的起始位置和大小
     * 2、分割
     */
    public void Split() throws IOException {
        // 总长度
        long len = src.length();

        // 起始位置和实际大小
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for(int i = 0; i < size; i++){
            beginPos = i*blockSize;
            if(i == size -1){ // 最后一块
                actualSize = (int)len;
            }else{
                actualSize = blockSize;
                len -= actualSize; // 剩余量
            }
            SplitDetail(i,beginPos,actualSize);
        }
    }

    private void SplitDetail(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");
        // 随机读取
        raf.seek(beginPos);
        // 操作
        byte[] flush = new byte[1024];// 缓冲容器
        int len = -1; // 接收长度
        while((len = raf.read(flush)) != -1){
            if(actualSize > len){
                System.out.println(new String(flush,0,len));
                raf2.write(flush,0,len);
                actualSize -= len;
            }else{
                System.out.println(new String(new String(flush,0,actualSize)));
                raf2.write(flush,0,actualSize);
                break;
            }
        }
        raf.close();
        raf2.close();
    }

    /**
     * 文件的合并
     */
    public void Merge(String destPath) throws IOException {
        // 输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath, true));// 这里的true代表追加在原文件上
        // 输入流
        for(int i = 0; i < size; i++){
            InputStream is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
            // 拷贝
            byte[] flush = new byte[1024];
            int len = -1;
            while((len = is.read(flush)) != -1){
                os.write(flush,0,len);
            }
            os.flush();
            is.close();
        }
        os.close();



    }

    public static void main(String[] args) throws IOException {
        SplitFile sf = new SplitFile("IO.png","Split",1024*10);
        sf.Split();
    }
}
