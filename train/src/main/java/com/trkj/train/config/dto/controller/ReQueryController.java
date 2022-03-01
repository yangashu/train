package com.trkj.train.config.dto.controller;

import com.trkj.train.config.Result;
import com.trkj.train.config.dto.service.ReQuerySerivce;
import com.trkj.train.entity.SysStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ReQuery")
public class ReQueryController {
    @Autowired
    private ReQuerySerivce service;

    @PostMapping("/requery/{pass}")
    public Result requery(@PathVariable int pass, @RequestBody SysStaff staff){
        return service.requery(pass,staff);
    }
}
