package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author Ryan
 * @Date 2020/3/26 20:41
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class User implements Serializable{
    private String name;
    private String password;
    private Boolean isAdmin;
    private String createtime;
    private Boolean status;
}
