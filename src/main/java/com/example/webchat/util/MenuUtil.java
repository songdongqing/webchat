package com.example.webchat.util;

import java.util.ArrayList;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class MenuUtil {

    public static final String TITLE = "欢迎关注良劵，请输入菜单序号：";
    public static final String NEXTLINE = "\n";
    public static final String TAB = "     ";
    public static final String SPLIT = ".";

    public static  String getMenu(){

        String menus[] = {"优惠券","讲故事","飞哥传书","打赏"};

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE).append(NEXTLINE);

        for (int i=0;i<menus.length;i++) {
            stringBuilder.append(i+1).append(SPLIT).append(menus[i])
                         .append(TAB).append(TAB).append(TAB).append(NEXTLINE);
        }
        return new String(stringBuilder);

    }

    public static void main(String[] args){
        String menu = getMenu();
        System.out.println(menu);
    }
}