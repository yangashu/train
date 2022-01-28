package com.trkj.train.controller;


import com.trkj.train.entity.CantonAttendance;
import com.trkj.train.service.ICantonAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/canton-attendance")
public class CantonAttendanceController {

    @Autowired
    private ICantonAttendanceService service;

    @PostMapping("/one")
    public List<CantonAttendance> one(@RequestParam("staffId")int staffId){
        return service.two(staffId);
    }
}
