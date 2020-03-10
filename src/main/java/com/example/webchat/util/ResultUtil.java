package com.example.webchat.util;


import com.example.webchat.entity.Result;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class ResultUtil {
    private static final Integer SUCCESS_STATUS = 200;
    private static final Integer FALSE_STATUS = 500;
    public static Result success(){
        Result result = new Result();
        result.setSuccess(true);
        result.setStatus(SUCCESS_STATUS);
        return result;

    }

    public static Result success(Object data){
        Result result = new Result();
        result.setSuccess(true);
        result.setStatus(SUCCESS_STATUS);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg){
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(msg);
        result.setStatus(FALSE_STATUS);
        return result;

    }
}