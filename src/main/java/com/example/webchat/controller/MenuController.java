package com.example.webchat.controller;

import com.example.webchat.entity.Menu;
import com.example.webchat.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:菜单控制器
 */
//id menu_name order_num menu_type parent_id
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @ResponseBody
    @RequestMapping("/delete")
    public int deleteById(@RequestParam("id") String id){
        return menuService.deleteById(id);
    }

    @ResponseBody
    @RequestMapping("/insert")
    public int insert(@RequestBody Menu menu){
        return menuService.insert(menu);
    }

    @ResponseBody
    @RequestMapping("/select")
    public Menu selectById(@RequestParam("id") String id){
        return menuService.selectById(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    public int  update(@RequestBody Menu menu){
        return menuService.update(menu);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Menu> selectAll(){
        return menuService.selectSon("2");
    }

}