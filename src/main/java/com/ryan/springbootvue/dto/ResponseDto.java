package com.ryan.springbootvue.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Author Ryan
 * @Date 2020/2/21 20:43
 * version 1.0
 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class ResponseDto {
    private static ResponseDto responseDto;

    private Integer code;
    private String msg;
    private Object data;
    private Integer all;


    public ResponseDto(){
    }

    public static ResponseDto instance(){
        if (null==responseDto){
            synchronized (ResponseDto.class){
                if (null==responseDto){
                    responseDto=new ResponseDto();
                }
            }
        }
        return  responseDto;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 返回错误信息
     * @param msg 错误信息
     * @return
     */
    public ResponseDto err(String msg){
        responseDto.setAll(0);
        responseDto.setCode(400);
        responseDto.setMsg(msg);
        responseDto.setData(null);
        return responseDto;
    }
    /**
     * 返回正确信息
     * @param data 返回数据
     * @return
     */
    public ResponseDto ok(Object data,Integer num){
        responseDto.setAll(num);
        responseDto.setCode(200);
        responseDto.setMsg("请求成功");
        responseDto.setData(data);
        return responseDto;
    }
}
