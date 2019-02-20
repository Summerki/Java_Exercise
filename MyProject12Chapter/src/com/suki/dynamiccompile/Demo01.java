package com.suki.dynamiccompile;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 通过IO流操作，将字符串存储成一个临时文件(Hi.java)，然后调用动态编译方法
        String str = "public class Hi{public static void main(String[] args){System.out.println(\"Hi\")}}";

        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null, null, null, "E:\\1-Java-Exercise\\Java_Exercise\\MyJava\\Hello.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");

        // 通过Runtime调用执行类；实现两个进程之间的通信
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp E:\\1-Java-Exercise\\Java_Exercise\\MyJava Hello");

        InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = reader.readLine()) != null){
            System.out.println(info);
        }

    }
}

