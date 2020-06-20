package com.ryan.springbootvue.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Ryan
 * @Date 2020/6/6 17:41
 * version 1.0
 */
@Data
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
public class ParameterDto implements Serializable {
    public static ParameterDto parameterDto;

    private Integer code;
    private Object data;
    private String msg;

    public ParameterDto(){

    }
    public static ParameterDto getInstance(){
        if (null==parameterDto){
            synchronized (ResponseDto.class){
                if (null==parameterDto){
                    parameterDto=new ParameterDto();
                }
            }
        }
        return  parameterDto;
    }
    public ParameterDto error(){
        parameterDto.setCode(400);
        parameterDto.setData(null);
        parameterDto.setMsg("获取数据失败！");
        return parameterDto;
    }

    public ParameterDto succ(Object data){
        parameterDto.setCode(200);
        parameterDto.setData(data);
        parameterDto.setMsg("获取数据成功！");
        return parameterDto;
    }

}
