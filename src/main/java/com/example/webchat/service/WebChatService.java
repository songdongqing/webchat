package com.example.webchat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.webchat.constant.MenuEnum;
import com.example.webchat.constant.RedisKey;
import com.example.webchat.entity.*;
import com.example.webchat.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 处理接收信息和回复消息的服务类接口
 *
 * @author Administrator
 *
 */
@Service
public class WebChatService {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MenuService menuService;

    @Autowired
    CouponsService couponsService;



    private String mainTextMessage(String content,TextMessage textMessage,VoiceMessage voiceMessage,ImageMessage imgmsg) throws IOException {

        String respXml = null;

        switch (content){

            //主菜单
            case "0" : {
                textMessage.setContent(MenuUtil.getMenu(menuService.selectAll()));
                respXml = MessageUtil.textMessageToXml(textMessage);
                break;
            }

            //优惠券
            case "1" : {
                redisTemplate.opsForValue().set(RedisKey.getMainType(textMessage.getToUserName()),MenuEnum.YOUHUANUAN.getCode());
//                textMessage.setContent("请输入商品名：");
                textMessage.setContent("http://tktdkb.cn/coupons/toGetCoupons?id="+textMessage.getToUserName());
                respXml =  MessageUtil.textMessageToXml(textMessage);
                break;
            }

            //讲故事
            case "2" :{
                redisTemplate.opsForValue().set(RedisKey.getMainType(textMessage.getToUserName()),MenuEnum.JIANGBUSHI.getCode());
                textMessage.setContent(MenuUtil.getMenu(menuService.selectSon(MenuEnum.JIANGBUSHI.getCode())));
                respXml = MessageUtil.textMessageToXml(textMessage);
                break;
            }

            // 飞哥传书
            case "3" : {
                redisTemplate.opsForValue().set(RedisKey.getMainType(textMessage.getToUserName()),MenuEnum.FEIGECHUANSHU.getCode());
                break;
            }

            //打赏
            case "4" : {
                redisTemplate.opsForValue().set(RedisKey.getMainType(textMessage.getToUserName()),MenuEnum.DASHANG.getCode());
                String filepath="/home/image/1.jpg";
                String mediaId = HttpUtil.upload(filepath,MessageType.RESP_MESSAGE_TYPE_IMAGE,redisTemplate);

                Image img = new Image();
                img.setMediaId(mediaId);
                imgmsg.setImage(img);

                respXml =  MessageUtil.imageMessageToXml(imgmsg);
                break;
            }
        }

        return respXml;
    }


    private String sonTextMessage(String menuId,String content,TextMessage textMessage,VoiceMessage voiceMessage,ImageMessage imgmsg) throws IOException {

        String respXml = null;

        if(content.equals(MenuEnum.MAINMENU.getCode())){
            redisTemplate.delete(RedisKey.getMainType(textMessage.getToUserName()));
            textMessage.setContent(MenuUtil.getMenu(menuService.selectAll()));
            respXml = MessageUtil.textMessageToXml(textMessage);
        }else {
            switch (menuId){
                //优惠券
                case "1" : {
                    //获取传过来的商品名字
                    List<Coupons> couponsByName = couponsService.getCouponsByName(content);
                    StringBuilder stringBuilder = new StringBuilder();
                    for(Coupons coupons : couponsByName){
                       stringBuilder.append(coupons.getTradeName()+"\n");
                       stringBuilder.append("优惠券面值："+coupons.getCouponValue()+"\n");
                       stringBuilder.append(coupons.getProductCouponPromotionLink()+"\n"+"\n");
                    }
                    textMessage.setContent(stringBuilder.toString());
                    respXml = MessageUtil.textMessageToXml(textMessage);
                    break;
                }

                //讲故事
                case "2" :{

                    if(content.equals("1")){

                        textMessage.setContent("小狼狗");
                        respXml = MessageUtil.textMessageToXml(textMessage);
                        break;

                    }else if(content.equals("2")){
//                        String filepath="/home/image/voice.mp3";
//                        //获取MediaId 通过素材管理中的接口上传多媒体文件，得到的id
//                        String mediaId = HttpUtil.upload( filepath, MessageType.RESP_MESSAGE_TYPE_VOICE,redisTemplate);
//                        Voice voice = new Voice();
//                        voice.setMediaId(mediaId);
//                        voiceMessage.setVoice(voice);
//                        respXml =  MessageUtil.voiceMessageToXml(voiceMessage);

                        textMessage.setContent("大鱼和小鱼");
                        respXml = MessageUtil.textMessageToXml(textMessage);
                        break;
                    }

                }

                // 飞哥传书
                case "3" : {
                    textMessage.setContent("暂无菜单项");
                    respXml = MessageUtil.textMessageToXml(textMessage);
                    break;
                }

                //打赏
                case "4" : {
                    textMessage.setContent("暂无菜单项");
                    respXml = MessageUtil.textMessageToXml(textMessage);
                    break;
                }
            }
        }

        return respXml;
    }
    // 处理微信发来的请求 map 消息业务处理分发
    public  String parseMessage(Map<String, String> map) throws IOException {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            //获取消息内容
            String content = map.get("Content");

            TextMessage textMessage = new TextMessage();
            textMessage.createMessage(fromUserName,toUserName,MessageType.RESP_MESSAGE_TYPE_TEXT);

            VoiceMessage voiceMessage = new VoiceMessage();
            voiceMessage.createMessage(fromUserName,toUserName,MessageType.RESP_MESSAGE_TYPE_VOICE);

            ImageMessage imgmsg = new ImageMessage();
            imgmsg.createMessage(fromUserName,toUserName,MessageType.RESP_MESSAGE_TYPE_IMAGE);

            if (MsgType.equals(MessageType.TEXT_MESSAGE)) {

                Object o = redisTemplate.opsForValue().get(RedisKey.getMainType(textMessage.getToUserName()));
                if(o==null){
                    respXml = mainTextMessage(content,textMessage,voiceMessage,imgmsg);
                }else {
                    String menuId = (String) o; //menuId 主菜单序列号 ， content 子菜单序列号
                    respXml = sonTextMessage(menuId,content,textMessage,voiceMessage,imgmsg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    // 事件消息业务分发
    public  String parseEvent(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            //获取事件类型
            String eventType = map.get("Event");

            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了

            if (eventType.equals(MessageType.EVENT_TYPE_SUBSCRIBE)) {// 关注
                TextMessage textMessage = new TextMessage();
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(new Date().getTime());
                textMessage.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
                textMessage.setContent(MenuUtil.getMenu(menuService.selectAll()));
                respXml = MessageUtil.textMessageToXml(textMessage);
            }
            if (eventType.equals(MessageType.EVENT_TYPE_UNSUBSCRIBE)) {// 取消关注

            }
            if (eventType.equals(MessageType.EVENT_TYPE_SCAN)) {// 用户已关注时的扫描带参数二维码

            }
            if (eventType.equals(MessageType.EVENT_TYPE_LOCATION)) {// 上报地理位置

            }
            if (eventType.equals(MessageType.EVENT_TYPE_CLICK)) {// 自定义菜单

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}