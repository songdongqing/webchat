package com.example.webchat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class HttpUtil {

    public static String getToken() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential" +
                     "&appid=wxebc0b57bfffe68b6&secret=1906a2e0b586bbbd718035b24e0ce61c";

        Connection con = Jsoup.connect(url).ignoreContentType(true);

        Document doc = con.get();
        String data = doc.text().toString();
        System.out.println(data);
        return JSON.parseObject(data).getString("access_token");
    }

    public static void main(String[] args) throws IOException {
       upload("1.jpg","C:\\Users\\L\\Desktop\\1.jpg");
    }

    public static String upload(String fileName,String filePath) throws IOException {

        File file = new File(filePath);

        String url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token="
                +getToken()+ "&type=image";;
        Connection conn = Jsoup.connect(url).ignoreContentType(true);

        conn.data("file", file.getName(), new FileInputStream(file));

        Document doc = conn.post();
        String data = doc.text().toString();
        System.out.println(data);

        return JSON.parseObject(data).getString("media_id");
    }
}