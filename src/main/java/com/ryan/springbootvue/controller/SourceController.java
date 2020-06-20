package com.ryan.springbootvue.controller;

import com.ryan.springbootvue.dto.ParameterDto;
import com.ryan.springbootvue.entity.Parameter;
import com.ryan.springbootvue.service.para.ParameterService;
import com.ryan.springbootvue.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Paths;

/**
 * @Author Ryan
 * @Date 2020/6/4 17:30
 * version 1.0
 */
@RestController
public class SourceController {
    @Autowired
    private ParameterService parameterService;
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/lines-bus.json")
    @ResponseBody
    public String getLinesbus() throws IOException {
        StringBuffer stringBuffer=new StringBuffer();
        FileReader fileReader=new FileReader(String.valueOf(Paths.get("src/main/resources/static/lines-bus.json")));
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        LineNumberReader reader = new LineNumberReader(bufferedReader);
        String str="";
        while ((str=reader.readLine())!=null){
            stringBuffer.append(str);
//            .append(System.getProperty("str.separator"));
        }
        String content=stringBuffer.toString();
        return content;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/parameter")
    public ParameterDto getAllPara(){
        return parameterService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/parameterById")
    @ResponseBody
    @CrossOrigin
    public ParameterDto getParaById(@RequestParam Integer id){
        return parameterService.findById(id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/journal")
    public ParameterDto getAllJournal(){
        return userService.findAllJournal();
    }
}
