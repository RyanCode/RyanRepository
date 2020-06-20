package com.ryan.springbootvue.controller;


import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.UserFile;
import com.ryan.springbootvue.service.user.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @Author Ryan
 * @Date 2020/6/9 20:43
 * version 1.0
 */
@RestController
public class FileOper {
    @Autowired
    private UserFileService userFileService;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST,value = "/upload")
    public void upLoad(@RequestParam("file") MultipartFile mfile, HttpServletRequest request) {
        String userId = request.getHeader("Cookies");
        UserFile userFile=new UserFile()
                .setUserId(userId);
        userFileService.upload(mfile,userFile);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/fileList")
    public ResponseDto getFile(){
        return userFileService.getFileList();
    }
}
