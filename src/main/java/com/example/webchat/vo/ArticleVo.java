package com.example.webchat.vo;


import com.example.webchat.entity.Article;
import com.example.webchat.entity.Paragraph;
import com.example.webchat.entity.Photo;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description: http请求返回的对象
 */

@Data
public class ArticleVo {
    private Article article;

    private List<Paragraph> paragraphs;

    private List<Photo> photos;

}