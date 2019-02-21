package com.suki.jvm;

/**
 * 自定义文件系统类加载器
 */
public class FileSystemClassLoader extends ClassLoader {
    // com.suki.jvm  -->  d:/myjava/  com.suki.jvm.
    private String rootDir;

    public FileSystemClassLoader() {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        // 应该要先查询有没有加载过这个类。如果已经加载，则返回加载好的类；如果没有则加载新的类
        if(c != null){
            return c;
        }else {

        }
    }
}
