package com.example.webchat.entity;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:返回给小可爱的
 */
@Data
public class Result<T> {
    String msg;
    Integer status;
    boolean success;
    T data;
}