package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Ryan
 * @Date 2020/6/9 16:51
 * version 1.0
 */
@Data
@AllArgsConstructor
public class Journals implements Serializable {
    private int id;
    private String acc;
    private String ip;
    boolean status;
    String date;

    public Journals() {
    }
}
