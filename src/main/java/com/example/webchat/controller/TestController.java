package com.example.webchat.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;
import java.util.Set;

import com.example.webchat.util.HttpUtil;
import com.example.webchat.util.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author gede
 * @version date：2019年5月28日 下午7:20:08
 * @description ：
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    RedisTemplate redisTemplate;


    @RequestMapping(value="/test",method=GET)
    @ResponseBody
    public String upload() throws IOException {

        System.out.println(HttpUtil.upload("C:\\Users\\L\\Desktop\\1.jpg", MessageType.RESP_MESSAGE_TYPE_IMAGE,redisTemplate));
        return "ok";
    }

    @RequestMapping(value="/redisKeys",method=GET)
    @ResponseBody
    public Set redisKeys() throws IOException {
        return redisTemplate.keys("*");
    }

}