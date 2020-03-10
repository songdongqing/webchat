package com.example.webchat.controller;

import com.example.webchat.dto.ArticleDTO;
import com.example.webchat.entity.Article;
import com.example.webchat.entity.Category;
import com.example.webchat.entity.Result;
import com.example.webchat.service.ArticleService;
import com.example.webchat.service.CategoryService;
import com.example.webchat.service.ParagraphService;
import com.example.webchat.service.PhotoService;
import com.example.webchat.util.ResultUtil;
import com.example.webchat.util.UuidUtil;
import com.example.webchat.vo.ArticleVo;
import com.example.webchat.vo.UpdateArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    ParagraphService paragraphService;
    @Autowired
    PhotoService photoService;


    //查询 List
    @RequestMapping("/list")
    @ResponseBody
    public List<Article> list(){
        return articleService.list();
    }

    //根据ID删除记录
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        boolean b = articleService.deleteArticleById(id);
        if(b){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    /*
     * 功能描述:
     * 注意命名的问题，不能重复，因为redis有缓存
     *
     * @param:   [id]
     * @return : com.sq.bookstore.entity.ArticleDTO
     * @author : chenfeiliang
     */
    //根据ID查询单个记录
    @ResponseBody
    @RequestMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable("id") String id){
        //用户每次访问文章的详情页面，计数器就+1,以文章的ID作为主键
         if(stringRedisTemplate.opsForHash().get("num",id)==null){
             stringRedisTemplate.opsForHash().put("num",id,"1");
         }else{
             stringRedisTemplate.opsForHash().increment("num",id,1);
         }
        String count = (String) stringRedisTemplate.opsForHash().get("num",id);

        ArticleDTO articleDTO =  articleService.getArticleById(id);

        articleDTO.getArticle().setLookNum(Integer.parseInt(count));
        return articleDTO;
    }

    //添加记录
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertArticle(@RequestBody ArticleVo articleVo){

        Category category = categoryService.getCategoryById(articleVo.getArticle().getCategoryId());

        String articleId = UuidUtil.getUUID32();

        articleVo.getArticle().setArticleId(articleId);

        boolean b = articleService.insertArticle(articleVo.getArticle());

        paragraphService.insert(articleVo.getParagraphs(),articleId);

        photoService.insert(articleVo.getPhotos(),articleId);

        if(category==null){
            return ResultUtil.fail("无该类别");
        }

        if(b){
            return ResultUtil.success();
        }else{
            return ResultUtil.fail("添加失败");
        }
    }

    //根据ID更新记录
    @RequestMapping("/update")
    @ResponseBody
    public Result updateArticle(@RequestBody UpdateArticleVo updateArticleVo){
        boolean b = articleService.updateArticle(updateArticleVo.getArticle());
        paragraphService.updateByPrimaryKey(updateArticleVo.getParagraphs());
        photoService.updateByPrimaryKey(updateArticleVo.getPhotos());
        if(b){
            return ResultUtil.success();
        }else {
            return ResultUtil.fail("更新失败");
        }
    }

}