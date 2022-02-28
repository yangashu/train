package com.trkj.train.controller;


import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.service.ISysPersonalService;
import com.trkj.train.service.impl.SysPersonalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/sys-personal")
public class SysPersonalController {


    @Autowired
    private SysPersonalServiceImpl service;

    @PostMapping("/up")
    public int xiugai(@RequestBody SysPersonal sysPersonal){
        int xiugai = service.xiugai(sysPersonal);
        return xiugai;
    }

}
