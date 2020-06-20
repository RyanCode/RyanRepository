package com.ryan.springbootvue.service.user;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.UserFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Ryan
 * @Date 2020/6/9 21:55
 * version 1.0
 */
public interface UserFileService {

    void save(UserFile userFile);

    void upload(MultipartFile mfile,UserFile userFile);

    ResponseDto getFileList();
}
