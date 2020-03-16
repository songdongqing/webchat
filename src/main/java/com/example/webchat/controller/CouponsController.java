package com.example.webchat.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.example.webchat.entity.Coupons;
import com.example.webchat.service.CouponsService;
import com.example.webchat.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
//@RequestMapping("/coupons")
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
            ExecutorService fixPool = Executors.newFixedThreadPool(10);
            fixPool.execute(new Runnable() {
                @Override
                public void run() {
                        for(Coupons coupon :coupons){
                            fixPool.execute(new Runnable() {
                                @Override
                                public void run() {
                                    coupon.setId(UuidUtil.getUUID32());
                                    int n = couponsService.insert(coupon);
                                    log.info("插入优惠券数据，{},",coupon);
                                }
                            });
                        }
                };
            });

            return "导入成功";
        } catch( Exception e) {
            e.printStackTrace();
        }
        return "文件上传失败！";
    }

    //根据商品名查找优惠券
    @ResponseBody
    @RequestMapping("/getCouponsByName")
    public List<Coupons> getCouponsByName(@RequestParam("name")String name){

        List<Coupons> couponsByName = couponsService.getCouponsByName(name);
        System.out.println("Controller:"+name);
        return couponsByName;
    }

}