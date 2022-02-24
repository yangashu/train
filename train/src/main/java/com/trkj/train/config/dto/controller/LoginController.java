package com.trkj.train.config.dto.controller;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.service.LoginService;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.mapper.SysMenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/a")
    private String a(){
        return "草泥马";
    }

    //    登录
    @PostMapping("/login")
    public Result login(@RequestBody SysStaff staff){
        log.debug("debug:  ------------------------------------");
        return service.login(staff);
    }
    //    退出登录
    @RequestMapping("logout")
    public Result logout(){
        return service.logout();
    }
}
