package com.example.webchat.service;

import com.example.webchat.entity.Coupons;
import com.example.webchat.entity.CouponsExample;
import com.example.webchat.mapper.CouponsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
public class CouponsService {
    @Autowired
    CouponsMapper couponsMapper;

    public int insert(Coupons coupons){
        return couponsMapper.insert(coupons);
    }

    //模糊查找 要加 %
    public List<Coupons> getCouponsByName(String name){
        String pName = "%"+name+"%";
        CouponsExample couponsExample = new CouponsExample();
        CouponsExample.Criteria criteria = couponsExample.createCriteria();
        criteria.andTradeNameLike(pName);
        couponsExample.setOrderByClause("monthly_merchandise_sales DESC limit 3");
        System.out.println("Service:"+pName);
        return couponsMapper.selectByExample(couponsExample);
    }
}