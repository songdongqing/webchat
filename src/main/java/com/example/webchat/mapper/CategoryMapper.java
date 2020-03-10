package com.example.webchat.mapper;

import com.example.webchat.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM `category`")
    public List<Category> list();

    @Select("SELECT * FROM `category` where category_id = #{categoryId}")
    public Category getCategoryById(String categoryId);

    @Delete("delete from category where category_id = #{categoryId}")
    public boolean deleteCategoryById(String categoryId);

    @Insert("insert into category values (#{categoryId},#{typeName},#{remark},#{ext1},#{ext2},#{ext3})")
    public boolean insertCategory(@Param("categoryId") String categoryId, @Param("typeName") String typeName, @Param("remark") String remark,
                                  @Param("ext1") String ext1, @Param("ext2") String ext2, @Param("ext3") String ext3);

    @Update("update category set type_name=#{typeName},remark=#{remark},ext1=#{ext1},ext2=#{ext2},ext3=#{ext3} where category_id = #{categoryId}")
    public boolean updateByID(@Param("categoryId") String categoryId, @Param("typeName") String typeName, @Param("remark") String remark,
                              @Param("ext1") String ext1, @Param("ext2") String ext2, @Param("ext3") String ext3);


}