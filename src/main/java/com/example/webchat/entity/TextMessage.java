package com.example.webchat.entity;

/**
 * Author:   chenfeiliang
 * Description:
 */

import com.example.webchat.entity.BaseMessage;
import com.example.webchat.util.MessageType;

import java.util.Date;

/**
 * 文本消息
 * @author Administrator
 *
 */
public class TextMessage extends BaseMessage {
    //文本消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String getMsgType() {
        return MessageType.TEXT_MESSAGE.toString();
    }

}