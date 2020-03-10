package com.example.webchat.mapper;


import com.example.webchat.entity.Paragraph;
import com.example.webchat.entity.ParagraphExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParagraphMapper {
    long countByExample(ParagraphExample example);

    int deleteByExample(ParagraphExample example);

    int deleteByPrimaryKey(String paragraphId);

    int insert(Paragraph record);

    int insertSelective(Paragraph record);

    List<Paragraph> selectByExampleWithBLOBs(ParagraphExample example);

    List<Paragraph> selectByExample(ParagraphExample example);

    Paragraph selectByPrimaryKey(String paragraphId);

    int updateByExampleSelective(@Param("record") Paragraph record, @Param("example") ParagraphExample example);

    int updateByExampleWithBLOBs(@Param("record") Paragraph record, @Param("example") ParagraphExample example);

    int updateByExample(@Param("record") Paragraph record, @Param("example") ParagraphExample example);

    int updateByPrimaryKeySelective(Paragraph record);

    int updateByPrimaryKeyWithBLOBs(Paragraph record);

    int updateByPrimaryKey(Paragraph record);
}