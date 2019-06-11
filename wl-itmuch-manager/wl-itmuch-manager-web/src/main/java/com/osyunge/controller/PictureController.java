package com.osyunge.controller;

import com.osyunge.dataobject.PictureResult;
import com.osyunge.service.PictureService;
import com.osyunge.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile){
        PictureResult result = pictureService.uploadPic(uploadFile);
        //把java对象转换成json对象
        String json= JsonUtils.objectToJson(result);
        return json;
    }
}
