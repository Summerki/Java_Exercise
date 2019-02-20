package com.suki.thread;

/**
 * @author Summerki
 */
public class ThreadDownloader extends Thread{
    private String url;// 远程路径
    private String name; // 存储名字
    public ThreadDownloader(String url, String name){
        this.url = url;
        this.name = name;
    }


    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.Download(url,name);
    }

    public static void main(String[] args) {
        ThreadDownloader td1 = new ThreadDownloader("", "");
        ThreadDownloader td2 = new ThreadDownloader("", "");
        ThreadDownloader td3 = new ThreadDownloader("", "");

        // 启动三个线程
        td1.start();
        td2.start();
        td3.start();

    }
}
