package com.example.webchat.dto;

import com.example.webchat.entity.Article;
import com.example.webchat.entity.Paragraph;
import com.example.webchat.entity.Photo;
import lombok.Data;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */

@Data
public class ArticleDTO {
    private String typeName;

    private Article article;

    private List<Paragraph> paragraphs;

    private List<Photo> photos;

}