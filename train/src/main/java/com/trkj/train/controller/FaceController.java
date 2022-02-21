package com.trkj.train.controller;

import com.baidu.aip.util.Base64Util;
import com.trkj.train.config.Result;
import com.trkj.train.service.impl.CantonSatffsignServiceImpl;
import com.trkj.train.utils.Face;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @PostMapping("/one")
    public Result one(MultipartFile url) throws Exception {
        Result result=face.two(Base64Util.encode(url.getBytes()));
        if(result.getCode().equals("0")){
            result = face.three(Base64Util.encode(url.getBytes()));
            if(result.getData()==null){
            }else{
                int userID=(int)result.getData();
                service.two(userID);
            }

        }
        return result;
    }

//    //检测是否有人脸存在
//    @PostMapping("/two")
//    public Result two(MultipartFile url) throws Exception {
//        Result result=face.two(Base64Util.encode(url.getBytes()));
//        if(result.getCode().equals("0")){
//            result = face.one(Base64Util.encode(url.getBytes()));
//        }
//        return result;
//
//    }
//
//    //人脸注册的方法
//
//    //人脸更新的方法
//
//    //人脸删除的方法
}
