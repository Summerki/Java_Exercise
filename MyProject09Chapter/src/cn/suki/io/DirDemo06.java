package cn.suki.io;



import java.io.File;
import java.io.FileReader;

/**
 * @author summerki
 */
public class DirDemo06 {
    public static void main(String[] args) {
        File src = new File("E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter");
        Count(src);
        System.out.println(len);
    }

    public static long len = 0;
    public static void Count(File src){
        if(src != null && src.exists()){
            if(src.isFile()){
                len += src.length();
            }else{
                for(File f : src.listFiles()){
                    Count(f);
                }
            }
        }
    }
}
