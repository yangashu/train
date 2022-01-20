package com.trkj.train.controller;


import com.trkj.train.config.Result;
import com.trkj.train.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/sys-dept")
public class SysDeptController {
    @Autowired
    private ISysDeptService service;
    @GetMapping("/list")
    public Result list(){
        return Result.success(service.list());
    }
}
