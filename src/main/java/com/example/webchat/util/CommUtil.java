package com.example.webchat.util;

import com.example.webchat.entity.Coupons;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class CommUtil {
    public static  List<List<T>>  splitList (List<T> mylist){
        List<List<T>>  list = new ArrayList<>();
        List<T> listTemp = new ArrayList<>();
        int num = 10000;
        for (int i = 0 ;i<mylist.size(); i++) {
            listTemp.add(mylist.get(i));
            if(i%(num-1)==0&&i!=0){
                list.add(listTemp);
                //批量插入
                listTemp = new ArrayList<>();
            }
        }
        return list;
    }
}