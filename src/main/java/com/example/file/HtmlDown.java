package com.example.file;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HtmlDown {


    public static void main(String[] args){
        saveHtml("https://www.jianshu.com/p/9c80af0d77ca");
    }

    /**
     *
     * @Title: saveHtml
     * @Description: 将抓取过来的数据保存到本地或者json文件
     * @param 参数
     * @return void 返回类型
     * @author liangchu
     * @date 2017-12-28 下午12:23:05
     * @throws
     */
    public static void saveHtml(String url) {
        try {
            // 这是将首页的信息存入到一个html文件中 为了后面分析html文件里面的信息做铺垫
            File dest = new File("/Users/ruankerui/Developer/test/temp/reptile.html");
            // 接收字节输入流
            InputStream is;
            // 字节输出流
            FileOutputStream fos = new FileOutputStream(dest);
            URL temp = new URL(url);
            // 这个地方需要加入头部 避免大部分网站拒绝访问
            // 这个地方是容易忽略的地方所以要注意
            URLConnection uc = temp.openConnection();
            // 因为现在很大一部分网站都加入了反爬虫机制 这里加入这个头信息
            uc.addRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 "
                            + "(iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) "
                            + "AppleWebKit/533.17.9"
                            + " (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
            is = temp.openStream();
            // 为字节输入流加入缓冲
            BufferedInputStream bis = new BufferedInputStream(is);
            // 为字节输出流加入缓冲
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            int length;
            byte[] bytes = new byte[1024 * 20];
            while ((length = bis.read(bytes, 0, bytes.length)) != -1) {
                fos.write(bytes, 0, length);
            }
            bos.close();
            fos.close();
            bis.close();
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
