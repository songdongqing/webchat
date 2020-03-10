package com.example.webchat.util;

import com.example.webchat.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class MenuUtil {

    public static final String TITLE = "欢迎关注良劵，请输入菜单序号：";
    public static final String NEXTLINE = "\n";
    public static final String TAB = "     ";
    public static final String SPLIT = ".";

    public static  String getMenu(List<Menu> menus){

//        String menus[] = {"优惠券","讲故事","飞哥传书","打赏"};

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(NEXTLINE);

        stringBuilder.append(0).append(SPLIT).append("主菜单")
                .append(TAB).append(TAB).append(TAB).append(NEXTLINE);

        for (int i=0;i<menus.size();i++) {
            stringBuilder.append(i+1).append(SPLIT).append(menus.get(i).getMenuName())
                         .append(TAB).append(TAB).append(TAB).append(NEXTLINE);
        }
        return new String(stringBuilder);

    }

//    public static void main(String[] args){
//        String menu = getMenu();
//        System.out.println(menu);
//    }
}