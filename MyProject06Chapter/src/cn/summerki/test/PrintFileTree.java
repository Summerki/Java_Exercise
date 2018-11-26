package cn.summerki.test;

import java.io.File;

/**
 * 打印文件树
 * @author summerki
 */
public class PrintFileTree {
    public static void main(String[] args) {
        File f = new File("/home/summerki/桌面/JavaWorkSpace_IDEA");
        printFileTree(f, 0);
    }

    /**
     *
     */
    public static void printFileTree(File file, int level){
        // 输出层数
        for(int i = 0; i < level; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File temp : files){
                printFileTree(temp, level + 1);
            }
        }
    }

}
