package com.ryan.springbootvue.service.user.imp;

import com.ryan.springbootvue.dto.ResponseDto;
import com.ryan.springbootvue.entity.UserFile;
import com.ryan.springbootvue.mapper.FileMapper;
import com.ryan.springbootvue.service.user.UserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author Ryan
 * @Date 2020/6/9 21:56
 * version 1.0
 */
@Service
public class UserFileServiceImpl implements UserFileService {
    @Autowired
    private FileMapper fileMapper;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    @Value("${file.path}")
//    private String filePath;
    @Override
    public void save(UserFile userFile) {
        fileMapper.save(userFile);
    }

    @Override
    public void upload(MultipartFile mfile,UserFile userFile) {
        if (!mfile.isEmpty()){
            String oldFileName=mfile.getOriginalFilename();
            String newFileName=System.currentTimeMillis()+ "." +oldFileName.substring(oldFileName.lastIndexOf(".")+1);
            String filePath="~/jars/upload";
            File dest=new File(filePath+newFileName);
            if (!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try {
                userFile.setOldFileName(oldFileName)
                        .setPath(filePath)
                        .setDownCounts(0)
                        .setSize(String.valueOf(mfile.getSize()))
                        .setUploadTime(sdf.format(new Date()))
                        .setNewFileName(newFileName);
                save(userFile);
                mfile.transferTo(dest);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public ResponseDto getFileList() {
        List<UserFile> file = fileMapper.getFile();
        return ResponseDto.instance().ok(file);
    }
}
