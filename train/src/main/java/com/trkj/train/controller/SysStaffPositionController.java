package com.trkj.train.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysMenu;
import com.trkj.train.entity.SysPositionMenu;
import com.trkj.train.entity.SysStaffPosition;
import com.trkj.train.service.ISysPositionService;
import com.trkj.train.service.ISysStaffPositionService;
import com.trkj.train.service.ISysStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
@RequestMapping("/sys-staff-position")
public class SysStaffPositionController {
    @Autowired
    private ISysStaffPositionService service;
    @Autowired
    private ISysPositionService positionService;
    @GetMapping("/find")
    public Result find(){
        return Result.success("200",null,positionService.list());
    }

    @GetMapping("/position")
    public Result<?> menu(int id){
        return service.position(id);
    }

    /**
     * 分配角色
     * @return
     */
    @PreAuthorize("hasAnyAuthority('sys:user','sys:user:perm','sys:manage')")
    @PostMapping("/role/{userId}")
    public Result perm(@PathVariable int userId, @RequestBody int[] roleIds) {
        return service.perm(userId,roleIds);
    }
}
