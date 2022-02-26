package com.trkj.train.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.CantonStaffleave;
import com.trkj.train.entity.vo.staffAndPersonalAndLeave;
import com.trkj.train.service.ICantonStaffleaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/canton-staffleave")
public class CantonStaffleaveController {

    @Autowired
    ICantonStaffleaveService service;

    @GetMapping("/leaveAll")
    public Result selectLeaveAll(@RequestParam("currentPage") int page,@RequestParam("pagesize") int size,@RequestParam("like") String like){
        IPage<staffAndPersonalAndLeave> iPage= service.selectLeaveAll(new Page(page,size),like);
        return Result.success(iPage);
    }
}
