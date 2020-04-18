package com.ryan.springbootvue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Ryan
 * @Date 2020/3/27 12:26
 * version 1.0
 */
@Data
@AllArgsConstructor
public class Result {
    private  static Result result;
    //响应码
    private int code;
    private String token;
    private Boolean isAdmin;

    public Result(){

    }


    public static Result getInstance(){
        if (null==result){
            synchronized (Result.class){
                if (null==result){
                    result=new Result();
                }
            }
        }
        return result;
    }
    public Result ok(){
        result.setCode(200);
        result.setToken("");
        result.setIsAdmin(true);
        return result;
    }

}
