package com.example.webchat.controller;


import com.example.webchat.entity.Category;
import com.example.webchat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    //查询所有的类别记录
    @RequestMapping("/list")
    @ResponseBody
    public List<Category> list(Model model){
        List<Category> categories = categoryService.list();
        return categories;
    }

    //根据ID查询单个记录
    @RequestMapping("/{id}")
    @ResponseBody
    public Category getCategoryById(@PathVariable("id") String id){
        Category category = categoryService.getCategoryById(id);
        return category;
    }

    //根据ID删除类别记录
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String deleteCategoryById(@PathVariable("id") String id){
        boolean b = categoryService.deleteCategoryById(id);
        if(b){
            return "该ID="+id+"记录已经成功删除！";
        }else{
            return "删除失败";
        }
    }

    //添加类别记录,跳转到input页面
//    @RequestMapping("/insert")
//    public String insertCategory(){
//        return "input";
//    }

    @PostMapping("/insert")
    @ResponseBody
    public String insertCategory(@RequestBody Category category){
        boolean b = categoryService.insertCategory(category);
        if(b){
            return "添加成功";
        }else {
            return "添加失败";
        }

    }

    //根据ID来修改类别记录,要先进行回显
//    @RequestMapping("/update/{id}")
//    @ResponseBody
//    public Category updateCategory(@PathVariable("id") String id){
//        Category category = categoryService.getCategoryById(id);
//        return category;
//    }

    //根据ID来修改类别记录
    @RequestMapping("/update")
    @ResponseBody
    public String updateCategoryById(Category category){
        boolean b = categoryService.updateCategoryById(category);
        if(b){
            return "更新ID="+category.getCategoryId()+"成功！";
        }else{
            return "更新失败！";
        }
    }
}