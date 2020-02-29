package com.example.webchat.controller;

import com.example.webchat.connect.CheckUtil;
import com.example.webchat.service.WebChatService;
import com.example.webchat.util.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
@RequestMapping(value = "/index")
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET)
    //接入开发者模式，通过GET方法
    public void get(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = response.getWriter();
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            //如果校验成功，将得到的随机字符串原路返回
            out.print(echostr);
        }

    }

    //消息的响应通过POST方式
    @RequestMapping(method=RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO 消息的接收、处理、响应
        // TODO 消息的接收、处理、响应
        //消息来源可靠性验证
        String signature = request.getParameter("signature");// 微信加密签名
        String timestamp = request.getParameter("timestamp");// 时间戳
        String nonce = request.getParameter("nonce");       // 随机数
        //确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        if (!CheckUtil.checkSignature(signature, timestamp, nonce)) {
            //消息不可靠，直接返回
            response.getWriter().write("");
            return;
        }
        //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            //调用parseXml方法解析请求消息
            Map<String, String> map = MessageType.parseXml(request, response);
            String msgType = map.get("MsgType");
            String xml = null;//处理输入消息，返回结果的xml
            if(MessageType.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
                xml = WebChatService.parseEvent(map);
            }else{
                xml = WebChatService.parseMessage(map);
            }
            //返回封装的xml
            //System.out.println(xml);
            response.getWriter().write(xml);
        } catch (Exception ex) {
            response.getWriter().write("");
        }
    }


}