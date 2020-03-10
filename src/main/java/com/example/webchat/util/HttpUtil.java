package com.example.webchat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.webchat.entity.Voice;
import com.example.webchat.entity.VoiceMessage;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

//        VoiceMessage voiceMessage = new VoiceMessage();
//        voiceMessage.setToUserName("cfl");
//        voiceMessage.setFromUserName("sdq");
//        voiceMessage.setCreateTime(new Date().getTime());
//        voiceMessage.setMsgType(MessageType.RESP_MESSAGE_TYPE_VOICE);
//
//        //获取MediaId 通过素材管理中的接口上传多媒体文件，得到的id
//        String mediaId = HttpUtil.upload( "C:\\Users\\L\\Desktop\\voice.mp3", MessageType.RESP_MESSAGE_TYPE_VOICE);
//
//
//        Voice voice = new Voice();
//        voice.setMediaId(mediaId);
//
//        voiceMessage.setVoice(voice);
//        String respXml =  MessageUtil.voiceMessageToXml(voiceMessage);
//
//        System.out.println(respXml);



    }

    public static String upload(String filePath,String type,RedisTemplate redisTemplate) throws IOException {

        String mediaId= null;

        File file = new File(filePath);

        if(redisTemplate.opsForValue().get(file.getName())!=null){

            mediaId = (String) redisTemplate.opsForValue().get(file.getName());

        }else {

            String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token="
                    +getToken()+ "&type="+type;
            Connection conn = Jsoup.connect(url).ignoreContentType(true);

            conn.data("file", file.getName(), new FileInputStream(file));

            Document doc = conn.post();
            String data = doc.text().toString();
            System.out.println(data);

            mediaId = JSON.parseObject(data).getString("media_id");

            redisTemplate.opsForValue().set(file.getName(),mediaId,3, TimeUnit.DAYS);


        }

        return mediaId;
    }
}