package com.example.webchat.entity;

/**
 * Author:   chenfeiliang
 * Description:语音消息封装类
 */
public class VoiceMessage extends BaseMessage {

    private Voice Voice;


    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}