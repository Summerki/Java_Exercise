package com.suki.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Summerki
 */
public class WebDownloader {
    public static void main(String[] args) {
    }

    /**
     * 下载图片（爬虫）
     * @param url 指定网址
     * @param name 下载存放的文件夹
     */
    public void Download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            System.out.println("不合法的图片路径");
        }
    }
}
