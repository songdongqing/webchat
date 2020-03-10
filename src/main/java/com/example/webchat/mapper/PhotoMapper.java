package com.example.webchat.mapper;

import com.example.webchat.entity.Photo;
import com.example.webchat.entity.PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(String photoId);

    int insert(Photo record);

    int insertSelective(Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(String photoId);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}