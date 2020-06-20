package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Ryan
 * @Date 2020/6/6 17:58
 * version 1.0
 */
@Data
@AllArgsConstructor
public class Parameter implements Serializable {
    private Integer id;
    private String name;
    private String value;
    private String info;
    private Date date;

}
