package com.example.webchat.mapper;

import com.example.webchat.entity.Coupons;
import com.example.webchat.entity.CouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponsMapper {
    long countByExample(CouponsExample example);

    int deleteByExample(CouponsExample example);

    int deleteByPrimaryKey(String id);

    int insert(Coupons record);

    int insertSelective(Coupons record);

    List<Coupons> selectByExample(CouponsExample example);

    Coupons selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Coupons record, @Param("example") CouponsExample example);

    int updateByExample(@Param("record") Coupons record, @Param("example") CouponsExample example);

    int updateByPrimaryKeySelective(Coupons record);

    int updateByPrimaryKey(Coupons record);
}