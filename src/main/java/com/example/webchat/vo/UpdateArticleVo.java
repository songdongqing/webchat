package com.example.webchat.vo;

import com.example.webchat.entity.Article;
import com.example.webchat.entity.Paragraph;
import com.example.webchat.entity.Photo;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description: Vo是接收前端传过来的数据类
 */
@Data
public class UpdateArticleVo {

    private Article article;

    private List<Paragraph> paragraphs;

    private List<Photo> photos;

}