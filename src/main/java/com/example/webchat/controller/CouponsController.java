package com.example.webchat.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.webchat.dto.GetCouponsReq;
import com.example.webchat.entity.Coupons;
import com.example.webchat.entity.Result;
import com.example.webchat.service.CouponsService;
import com.example.webchat.util.CommUtil;
import com.example.webchat.util.ResultUtil;
import com.example.webchat.util.UuidUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Controller
@Slf4j
@RequestMapping("/coupons")
public class CouponsController {

    @Autowired
    CouponsService couponsService;

    @RequestMapping("/toImportCoupons")
    public String toImportCoupons(){
        return "toImportCoupons";
    }

    @RequestMapping("/importCoupons")
    @ResponseBody
    public String importCoupons(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile){
        //判断文件是否为空
        if(multipartFile.isEmpty()){
            return "请不要上传空文件!";
        }
        try {
            int k = 0;
            ImportParams params = new ImportParams();
            List<Coupons> coupons = ExcelImportUtil.importExcel(multipartFile.getInputStream(),Coupons.class,params);
            coupons.stream().forEach(c->c.setId(UuidUtil.getUUID32()));
//            CommUtil.splitList(coupons);

//            couponsService.insertList(list);
//            ExecutorService fixPool = Executors.newFixedThreadPool(10);
//            fixPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                        for(Coupons coupon :coupons){
//                            fixPool.execute(new Runnable() {
//                                @Override
//                                public void run() {
//                                    coupon.setId(UuidUtil.getUUID32());
//                                    int n = couponsService.insert(coupon);
//                                    log.info("插入优惠券数据，{},",coupon);
//                                }
//                            });
//                        }
//                };
//            });

            return "导入成功";
        } catch( Exception e) {
            e.printStackTrace();
        }
        return "文件上传失败！";
    }

    //根据商品名查找优惠券
    @ResponseBody
    @RequestMapping("/getCouponsByName")
    @CrossOrigin
    public List<Coupons> getCouponsByName(@RequestParam("name")String name){

        List<Coupons> couponsByName = couponsService.getCouponsByName(name);
        System.out.println("Controller:"+name);
        return couponsByName;
    }

    /*
     * 功能描述:
     * 分页查询
     *
     * @param:
     * @return :
     * @author : chenfeiliang
     */
    @ResponseBody
    @RequestMapping("/getCoupons")
    @CrossOrigin
    public Result getCoupons(@RequestBody GetCouponsReq getCouponsReq){

        List<Coupons> list = null;

        Integer pageNum = getCouponsReq.getPageNum();
        Integer pageSize = getCouponsReq.getPageSize();

        log.info("pageNum=[{}],pageSize=[{}]",pageNum,pageSize);

        PageHelper.startPage(pageNum, pageSize);//这行是重点，表示从pageNum页开始，每页pageSize条数据
        list = couponsService.findAll(getCouponsReq);

        PageInfo<Coupons> pageInfo = new PageInfo<Coupons>(list);

        return ResultUtil.success(pageInfo);
    }


    @RequestMapping("/toGetCoupons")
    public String toGetCoupons(@RequestParam("id") String id){
        log.info("id=[{}]",id);
        return "toGetCoupons";
    }




}