package com.example.webchat.dto;

import lombok.Data;

/**
 * Author:   chenfeiliang
 * Description:
 */
@Data
public class GetCouponsReq {

    private Integer pageNum;
    private Integer pageSize;
    private String name;

}