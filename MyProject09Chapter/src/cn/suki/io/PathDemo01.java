package cn.suki.io;

import java.io.File;

/**
 * @author summerki
 */
public class PathDemo01 {
    public static void main(String[] args) {
        String path = "E:\\1-Java-Exercise\\Java_Exercise\\MyProject09Chapter\\IO.png"; // 自动转义
        System.out.println(File.separatorChar); // 输出 \

        // 建议写法
        path = "E:/1-Java-Exercise/Java_Exercise/MyProject09Chapter/IO.png"; // 将 \\ 换成 /\
        // 建议写法2 常量拼接  虽然这样很麻烦，但是肯定不会出错
        path = "D:" + File.separatorChar + "1-Java-Exercise" + File.separatorChar + "Java_Exercise" + File.separatorChar + "MyProject09Chapter" + File.separatorChar + "IO.png";

        System.out.println(path);
    }
}
