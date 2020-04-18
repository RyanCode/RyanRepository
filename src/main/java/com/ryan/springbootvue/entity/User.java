package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author Ryan
 * @Date 2020/3/26 20:41
 * version 1.0
 */
@Data
@AllArgsConstructor
public class User {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private Boolean isAdmin;
}
