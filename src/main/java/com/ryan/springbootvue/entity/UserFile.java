package com.ryan.springbootvue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Ryan
 * @Date 2020/6/9 21:43
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class UserFile implements Serializable {
    private Integer id;
    private String oldFileName;
    private String newFileName;
    private String path;
    private String size;
    private Integer downCounts;
    private String uploadTime;
    private String userId;
}
