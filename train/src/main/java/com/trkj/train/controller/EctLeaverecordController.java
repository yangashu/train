package com.trkj.train.controller;


import com.trkj.train.entity.EctLeaverecord;
import com.trkj.train.service.IEctLeaverecordService;
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
@RequestMapping("/ect-leaverecord")
public class EctLeaverecordController {
    @Autowired
    private IEctLeaverecordService iEctLeaverecordService;

    @PostMapping("/inserttuixuejil")
    public int inserttuixuesq(@RequestBody EctLeaverecord ectLeaverecord){
        return iEctLeaverecordService.inserttuixuejil(ectLeaverecord);
    }

}
