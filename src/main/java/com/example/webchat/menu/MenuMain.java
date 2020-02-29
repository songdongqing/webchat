package com.example.webchat.menu;
import com.alibaba.fastjson.JSONArray;
import com.example.webchat.core.WebChatConfig;
import com.example.webchat.util.JsonPost;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * @author gede
 * @version date：2019年5月28日 下午7:03:24
 * @description ：
 */
@Component
public class MenuMain {

    public String createMenu(){
        ClickButton cbt=new ClickButton();
        cbt.setKey("image");
        cbt.setName("回复图片");
        cbt.setType("media_id");


        ViewButton vbt=new ViewButton();
        vbt.setUrl("https://how2j.cn/");
        vbt.setName("学习网站");
        vbt.setType("media_id");

        JSONArray sub_button=new JSONArray();
        sub_button.add(cbt);
        sub_button.add(vbt);


        JSONObject buttonOne=new JSONObject();
        buttonOne.put("name", "菜单");
        buttonOne.put("sub_button", sub_button);

        JSONArray button=new JSONArray();
        button.add(vbt);
        button.add(buttonOne);
        button.add(cbt);

        JSONObject menujson=new JSONObject();
        menujson.put("button", button);
        System.out.println(menujson);

        String token = WebChatConfig.getToken(WebChatConfig.APPID,WebChatConfig.SECERT);

        //这里为请求接口的url   +号后面的是token，这里就不做过多对token获取的方法解释
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;
        //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
        try{
            String rs= JsonPost.jsonPost(url, menujson.toJSONString());
            System.out.println(rs);
            return rs;
        }catch(Exception e){
            System.out.println("请求错误！");
        }
        return null;
    }
}