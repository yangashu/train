package com.trkj.train.controller;

import com.baidu.aip.util.Base64Util;
import com.trkj.train.config.Result;
import com.trkj.train.service.impl.CantonSatffsignServiceImpl;
import com.trkj.train.utils.Face;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//人脸识别的Controller层

@RestController
@RequestMapping("/Face")
public class FaceController {
    @Autowired
    private Face face;

    @Autowired
    private CantonSatffsignServiceImpl service;

    //人脸识别的方法
    @PostMapping("/one/{id}")
    public Result one(@PathVariable("id")int id, @RequestParam("url") MultipartFile url) throws Exception {
        Result result=face.two(Base64Util.encode(url.getBytes()));
        if(result.getCode().equals("0")){
            result = face.three(Base64Util.encode(url.getBytes()));
            if(result.getData()==null){

            }else{
                int userID=(int)result.getData();
                if(userID==id){
                    service.two(userID);
                }else{
                    result=Result.error("-1","打卡人与当前账号不符");
                }

            }

        }
        return result;
    }
}
