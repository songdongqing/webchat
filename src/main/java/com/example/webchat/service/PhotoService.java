package com.example.webchat.service;

import com.example.webchat.entity.Photo;
import com.example.webchat.mapper.PhotoMapper;
import com.example.webchat.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class PhotoService {

    @Autowired
    PhotoMapper photoMapper;

    public int insert(List<Photo> photos, String articleId){
        for(Photo photo:photos){
            photo.setArticleId(articleId);
            photo.setPhotoId(UuidUtil.getUUID32());
            photoMapper.insert(photo);
        }
        return 0;
    }

    public int updateByPrimaryKey(List<Photo> photos){
        for(Photo photo:photos){
            photoMapper.updateByPrimaryKeySelective(photo);
        }
        return 0;
    }

}