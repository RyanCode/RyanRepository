package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author Ryan
 * @Date 2020/3/29 17:05
 * version 1.0
 */
@Data
@AllArgsConstructor
public class T_order implements Serializable{
    @NotBlank
    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String date;
    private String price;
    private String type;
    private String customer;
    private String cost;
    //反序列化需要无参构造器
    public T_order(){
    }

    @Override
    public String toString() {
        return "T_order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
