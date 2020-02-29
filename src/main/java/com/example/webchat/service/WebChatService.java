package com.example.webchat.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.webchat.entity.*;
import com.example.webchat.util.*;


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
public class WebChatService {
    // 处理微信发来的请求 map 消息业务处理分发
    public static String parseMessage(Map<String, String> map) {
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

            if (MsgType.equals(MessageType.TEXT_MESSAGE)) {
                //优惠券
                if(content.equals("1")){
                    TextMessage textMessage = new TextMessage();
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(new Date().getTime());
                    textMessage.setMsgType(MessageType.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setContent("https://how2j.cn/");

                    respXml =  ReplyMessageUtil.sendTextMessage(textMessage);
                    //打赏
                }else if (content.equals("4")){

                    String fileName = "payPhoto.jpg";
                    String filepath="/home/image/1.jpg";
                    String mediaId = HttpUtil.upload(fileName, filepath);

                    ImageMessage imgmsg = new ImageMessage();
                    Image img = new Image();

                    imgmsg.setToUserName(fromUserName);
                    imgmsg.setFromUserName(toUserName);
                    imgmsg.setCreateTime(new Date().getTime());
                    imgmsg.setMsgType(MessageType.RESP_MESSAGE_TYPE_IMAGE);
                    img.setMediaId(mediaId);
                    imgmsg.setImage(img);

                    respXml =  MessageUtil.imageMessageToXml(imgmsg);
                    //讲故事
                }else if(content.equals("2")){

                    VoiceMessage voiceMessage = new VoiceMessage();
                    Voice voice = new Voice();
                    voiceMessage.setToUserName(fromUserName);
                    voiceMessage.setFromUserName(toUserName);
                    voiceMessage.setCreateTime(new Date().getTime());
                    //获取MediaId 通过素材管理中的接口上传多媒体文件，得到的id

                    //voice.setMediaId();
                    voiceMessage.setMsgType(MessageType.RESP_MESSAGE_TYPE_VOICE);

                    respXml =  ReplyMessageUtil.sendVoiceMessage(voiceMessage);
                    //飞哥传书
                }else{

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    // 事件消息业务分发
    public static String parseEvent(Map<String, String> map) {
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
            Map<String, String> replyMap = new HashMap<String, String>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(new Date().getTime()));
            if (eventType.equals(MessageType.EVENT_TYPE_SUBSCRIBE)) {// 关注
                // 用map集合封装
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", MenuUtil.getMenu());
                respXml = XmlUtil.xmlFormat(replyMap, true);
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