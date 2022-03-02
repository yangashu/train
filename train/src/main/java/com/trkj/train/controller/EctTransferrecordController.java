package com.trkj.train.controller;


import com.trkj.train.entity.EctTransferrecord;
import com.trkj.train.service.IEctTransferrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/ect-transferrecord")
public class EctTransferrecordController {
    @Autowired
    private IEctTransferrecordService iEctTransferrecordService;

    //添加
    @PostMapping("insertzhuanban")
    public int insertzhuanban(@RequestBody EctTransferrecord ectTransferrecord){
        return iEctTransferrecordService.insertZhuanban(ectTransferrecord);
    }

}
