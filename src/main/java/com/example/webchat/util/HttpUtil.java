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

        //连接
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


//        String s = "商品id\t商品名称\t商品主图\t商品详情页链接地址\t商品一级类目\t淘宝客链接\t商品价格(单位：元)\t商品月销量\t收入比率(%)\t佣金\t卖家旺旺\t卖家id\t店铺名称\t平台类型\t优惠券id\t优惠券总量\t优惠券剩余量\t优惠券面额\t优惠券开始时间\t优惠券结束时间\t优惠券链接\t商品优惠券推广链接";
//        String[] datas = s.split("\t");
//        for(String data:datas){
//            transation(data);
//        }
        longtoShort("https://uland.taobao.com/coupon/edetail?e=DGCbxkDSM7Sa2P%2BN2ppgB9pKVcR7WyyReUhIlKyJKtxwxq3SDs4RQihZRtZdalofBPnQG9SaDjq8KhNTO91QrsYtSoQ%2FufyX%2F4Nx%2FkoOWX6hnG2fpYFJ2gDJfQIJtNgCdmHXzDbs7%2BcSNBSUlq%2B9Xusg1h6JkAnIYKB7L6zVbgw%3D&af=1&pid=mm_594070173_918050175_109477750253");



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

    public static String transation(String word) throws IOException {
        String url = "http://fanyi.so.com/index/search";
        Connection conn = Jsoup.connect(url).ignoreContentType(true);
        conn.header("Cookie","Q_UDID=586e044f-cc8a-89f9-b712-d8cb799adabd; __guid=144965027.3514460679563395600.1583930509655.9214; count=1");
//        conn.header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,und;q=0.7");
//        conn.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
        conn.header("pro","fanyi");
        //data会作为内容
        conn.data("eng","0");
        conn.data("validate","");
        conn.data("ignore_trans","0");
        conn.data("query",word);
        //发送post方法
        Document doc = conn.post();
        String stringData = doc.text().toString();
//        System.out.println(stringData);

        //转为json对象
        String data1 = JSON.parseObject(stringData).get("data").toString();
        String data = JSON.parseObject(data1).get("fanyi").toString()
                          .toLowerCase().replaceAll(" ","_").replaceAll(",","");
        String ss[] = {"%",":"};
        for(String s:ss){
            if(data.contains(s)){
                String[] split = data.split(s);
                data = split[0];
            }
        }

//        System.out.println(data);
        return data;
    }

    //长链接转为短链接
    public static String longtoShort(String link) throws IOException {
        String url = "http://create.suo.nz/pageHome/createBySingle.htm";
//        String url = "http://suo.nz/?from=baid";
        Connection conn = Jsoup.connect(url).ignoreContentType(true);
        conn.header("Cookie","Hm_lvt_63f6fb31024ac19ba80227052c8e0ff7=1584025892; sitename=29cba2a34ea24fec8584c75c629a262f; Hm_lpvt_63f6fb31024ac19ba80227052c8e0ff7=1584028192");
//        conn.header("Pragma","no-cache");
//        conn.header("Server","NWS_SPMid");
//        conn.header("X-Daa-Tunnel","hop_count=2");
//        conn.header("X-NWS-LOG-UUID","4790980035834680037 5c0e51a334e6d32d7c812604732f87fe");
//        conn.header("Server","NWS_SPMid");
//        conn.header("X-NWS-UUID-VERIFY","0cbfc7a570f0b9b9008040a0974f0d44");
//        conn.header("Origin","http://suo.nz");
//        conn.header("Host","create.suo.nz");
//        conn.header("Access-Control-Allow-Origin","http://suo.nz");
//        conn.header("Access-Control-Expose-Headers","Set-Cookie");
        conn.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36");
        conn.header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,und;q=0.7");
        conn.header("Host","create.suo.nz");
        conn.header("Origin","http://suo.nz");

        conn.data("from","baid");
        conn.data("random","1584026174219");
        conn.data("mark","fe166f01ab5195f00a79cd7013c77007");
        conn.data("domain","suo.nz");
        conn.data("key","0@null");
        conn.data("urlStr",link);
        conn.data("extDomain","");
        conn.data("expireType","1");


        Document doc = conn.post();
        String stringData = doc.text().toString();
        System.out.println(stringData);
        return "";
    }
}