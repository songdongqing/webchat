package com.example.webchat.util;

import com.example.webchat.entity.TextMessage;
import com.example.webchat.entity.VoiceMessage;

import java.io.Serializable;



/**
 * 构建回复消息
 *
 * @author Administrator
 *
 */
public class ReplyMessageUtil implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * <xml> <ToUserName>< ![CDATA[toUser] ]></ToUserName> <FromUserName><
     * ![CDATA[fromUser] ]></FromUserName> <CreateTime>12345678</CreateTime>
     * <MsgType>< ![CDATA[text] ]></MsgType> <Content>< ![CDATA[你好] ]></Content>
     * </xml> sendTextMessage
     * @param message
     * @return
     */
    public static String sendTextMessage(TextMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.TEXT_MESSAGE + "]]></MsgType>");
        sb.append("<Content><![CDATA[" + message.getContent() + "]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

    public static String sendVoiceMessage(VoiceMessage voiceMessage) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + voiceMessage.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + voiceMessage.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + voiceMessage.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MessageType.RESP_MESSAGE_TYPE_VOICE + "]]></MsgType>");
        sb.append("<Content><![CDATA[" + voiceMessage.getContent() + "]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

}