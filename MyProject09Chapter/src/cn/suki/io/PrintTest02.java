package cn.suki.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Summerki
 */
public class PrintTest02 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")));
        pw.println("打印流");
        pw.println(true);
        pw.close();
    }
}
