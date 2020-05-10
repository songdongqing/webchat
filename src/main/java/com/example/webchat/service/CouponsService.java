package com.example.webchat.service;

import com.example.webchat.dto.GetCouponsReq;
import com.example.webchat.entity.Coupons;
import com.example.webchat.entity.CouponsExample;
import com.example.webchat.mapper.CouponsMapper;
import com.example.webchat.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Service
@Slf4j
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

    public List<Coupons> getCoupons(){
//        CouponsExample couponsExample = new CouponsExample();
//        CouponsExample.Criteria criteria = couponsExample.createCriteria();
//        criteria.andTradeNameLike(pName);
//        couponsExample.setOrderByClause("monthly_merchandise_sales DESC limit 3");
//        System.out.println("Service:"+pName);
        CouponsExample couponsExample = new CouponsExample();
        couponsExample.setOrderByClause("monthly_merchandise_sales DESC limit 10");
        return couponsMapper.selectByExample(couponsExample);
    }

    public List<Coupons> findAll(GetCouponsReq getCouponsReq) {
        CouponsExample couponsExample = new CouponsExample();
        CouponsExample.Criteria criteria = couponsExample.createCriteria();
        if(getCouponsReq.getName() != null){
            criteria.andTradeNameLike("%"+getCouponsReq.getName()+"%");
            log.info("name=[{}]",getCouponsReq.getName());
        }
        String date = DateUtil.getStringDate(new Date());
        log.info("date=[{}]",date);
        criteria.andCouponClosingTimeGreaterThanOrEqualTo(date);
        //销量是字符串

        couponsExample.setOrderByClause("CAST(monthly_merchandise_sales AS DECIMAL) DESC");
        return couponsMapper.selectByExample(couponsExample);
    }


    public int insertList(List<Coupons> coupons){
        return couponsMapper.insertList(coupons);
    }
}