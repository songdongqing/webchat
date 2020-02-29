package com.example.webchat.entity;

/**
 * Author:   chenfeiliang
 * Description:语音消息封装类
 */
public class VoiceMessage extends BaseMessage {

    private Voice Voice;


    public com.example.webchat.entity.Voice getVoice() {
        return Voice;
    }

    public void setVoice(com.example.webchat.entity.Voice voice) {
        Voice = voice;
    }
}