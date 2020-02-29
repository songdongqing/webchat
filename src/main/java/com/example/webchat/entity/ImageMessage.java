package com.example.webchat.entity;

import com.example.webchat.util.MessageType;

/**
 * @author gede
 * @version date：2019年5月23日 下午9:45:39
 * @description ：图片消息的封装类
 */
public class ImageMessage extends BaseMessage{

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }


}