package com.example.webchat.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Builder;
import lombok.Data;

@Data
@ExcelTarget("coupons")
public class Coupons {

    private String id;

    @Excel(name = "商品id")
    private String productId;

    @Excel(name = "商品名称")
    private String tradeName;

    @Excel(name = "商品主图")
    private String mainChartOfCommodities;

    @Excel(name = "商品详情页链接地址")
    private String productInformationPageLinkAddress;

    @Excel(name = "商品一级类目")
    private String commodityCategoryI;

    @Excel(name = "淘宝客链接")
    private String linkToTaobao;

    @Excel(name = "商品价格(单位：元)")
    private String commodityPrice;

    @Excel(name = "商品月销量")
    private String monthlyMerchandiseSales;

    @Excel(name = "收入比率(%)")
    private String incomeRatio;

    @Excel(name = "佣金")
    private String commission;

    @Excel(name = "卖家旺旺")
    private String theSellerWantWant;

    @Excel(name = "卖家id")
    private String sellerId;

    @Excel(name = "店铺名称")
    private String nameOfShop;

    @Excel(name = "平台类型")
    private String platformType;

    @Excel(name = "优惠券id")
    private String couponId;

    @Excel(name = "优惠券总量")
    private String totalCoupons;

    @Excel(name = "优惠券剩余量")
    private String couponSurplus;

    @Excel(name = "优惠券面额")
    private String couponValue;

    @Excel(name = "优惠券开始时间")
    private String couponStartTime;

    @Excel(name = "优惠券结束时间")
    private String couponClosingTime;

    @Excel(name = "优惠券链接")
    private String couponLink;

    @Excel(name = "商品优惠券推广链接")
    private String productCouponPromotionLink;

    //商品id	商品名称	商品主图	商品详情页链接地址	商品一级类目	淘宝客链接	商品价格(单位：元)	商品月销量
    // 收入比率(%)	佣金	卖家旺旺	卖家id	店铺名称	平台类型	优惠券id	优惠券总量	优惠券剩余量	优惠券面额
    // 优惠券开始时间	优惠券结束时间	优惠券链接	商品优惠券推广链接
}