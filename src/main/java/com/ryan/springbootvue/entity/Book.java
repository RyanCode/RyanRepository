package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author Ryan
 * @Date 2020/3/14 22:34
 * version 1.0
 */
@Data
@AllArgsConstructor
public class Book {
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    private String author;
    private String date;

}
