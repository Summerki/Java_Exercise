package cn.suki.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @author Summerki
 */
public class RandTest01 {
    public static void main(String[] args) throws IOException {
        // 分多少块问题
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt");
        // 总长度
        long len = src.length();
        // 每块大小
        int blockSize = 10;
        // 块数：多少块
        int size = (int) Math.ceil(len * 1.0 / blockSize); // Math.ceil向上取整
        System.out.println(size);

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
            System.out.println(i + "--->" + beginPos + "--->" + actualSize);
            Split(i,beginPos,actualSize);
        }
    }


    public static void Split(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.txt"), "r");
        // 随机读取
        raf.seek(beginPos);
        // 操作
        byte[] flush = new byte[1024];
        int len = -1;
        while((len = raf.read(flush)) != -1){
            if(actualSize > len){
                System.out.println(new String(flush,0,len));
                actualSize -= len;
            }else{
                System.out.println(new String(new String(flush,0,actualSize)));
                break;
            }
        }
        raf.close();
    }
}




