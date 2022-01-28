package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.EctStudentattend;
import com.trkj.train.service.IEctStudentattendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/ect-studentattend")
public class EctStudentattendController {
    @Autowired
    private IEctStudentattendService service;

    @GetMapping("/one")
    public int one(){
        QueryWrapper<EctStudentattend> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("STUDENTATTEND_TYPE",2);
        List<EctStudentattend> list=service.one(queryWrapper);
        return list.size();
    }

    @GetMapping("/two")
    public int two(){
        QueryWrapper<EctStudentattend> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("STUDENTATTEND_TYPE",0);
        List<EctStudentattend> list=service.one(queryWrapper);
        return list.size();
    }

}
