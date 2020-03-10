package com.example.webchat.entity;

import com.example.webchat.util.MessageType;
import lombok.Data;

import java.util.Date;

/**
 * 请求消息的公共字段类
 *
 * @author Administrator
 *
 */
@Data
public abstract class BaseMessage {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息id，64位整型
    private long MsgId;
    private String Content;
    private String MsgType;

    public  void createMessage(String fromUserName,String toUserName,String msgType){
        this.setToUserName(fromUserName);
        this.setFromUserName(toUserName);
        this.setCreateTime(new Date().getTime());
        this.setMsgType(msgType);
    }

}