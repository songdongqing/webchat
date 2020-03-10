package com.example.webchat.constant;

/**
 * Author:   chenfeiliang
 * Description:
 */

public enum MenuTypeEnum {

    TYPE_1(1,"一级菜单"),
    TYPE_2(2,"二级菜单"),

    ;

    private Integer code;
    private String value;

    MenuTypeEnum(Integer code, String value){

        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
