package com.example.webchat.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.example.webchat.menu.MenuMain;
import com.example.webchat.util.HttpPostUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author gede
 * @version date：2019年5月28日 下午7:20:08
 * @description ：
 */
@Controller
@RequestMapping("/menue")
public class MenueController {

    private MenuMain menue;
    @Autowired
    public MenueController(MenuMain menue) {
        super();
        this.menue = menue;
    }

    @RequestMapping(value="/createMenu",method=GET)
    @ResponseBody
    public String home(){

        return menue.createMenu();
    }

    @RequestMapping(value="/upload",method=GET)
    @ResponseBody
    public String upload(){

        HttpPostUploadUtil util=new HttpPostUploadUtil();
        String filepath="C:\\Users\\L\\Desktop\\1.jpg";
        Map<String, String> textMap = new HashMap<String, String>();
        textMap.put("name", "testname");
        Map<String, String> fileMap = new HashMap<String, String>();
        fileMap.put("userfile", filepath);
        String mediaidrs = util.formUpload(textMap, fileMap);
        System.out.println(mediaidrs);
        String mediaid= JSON.parseObject(mediaidrs).getString("media_id");

        return mediaid;
    }

}