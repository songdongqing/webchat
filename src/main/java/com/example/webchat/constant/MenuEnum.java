package com.example.webchat.constant;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */

public enum MenuEnum {

    MAINMENU("0","主菜单"),
    YOUHUANUAN("1","优惠券"),
    JIANGBUSHI("2","讲故事"),
    FEIGECHUANSHU("3","飞给传书"),
    DASHANG("4","打赏"),
    HOUTAIGUANLIXT("5","后台管理系统")

    ;

    private String code;
    private String value;

    MenuEnum(String code,String value){

        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
