package com.trkj.train.controller;


import com.trkj.train.service.IPersonalReceivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.ReceivingView;
import com.trkj.train.entity.PersonalReceiving;
import com.trkj.train.service.IPersonalReceivingService;
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
@RequestMapping("/personal-receiving")
public class PersonalReceivingController {
    @Autowired
    private IPersonalReceivingService service;

    @GetMapping("/one")
    public int one(@RequestParam("staffId") int staffId){
        return service.one(staffId);
    }
    @Autowired
    private  IPersonalReceivingService receivingService;

    @GetMapping("/neiron")
    public IPage<ReceivingView> Neiron(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("id") int id){
        IPage<ReceivingView> iPage= receivingService.receiving(page, size,id);
        return iPage;
    }

    @GetMapping("/like")
    public IPage<ReceivingView> Like(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("like") String like,@RequestParam("id") int id){
        IPage<ReceivingView> iPage= receivingService.lickselect(page, size,like,id);
        return iPage;
    }

    @PostMapping("/dele")
    public int dele(@RequestBody PersonalReceiving receiving){
        int a = receivingService.dele(receiving.getReceivingId());
        return a;
    }

    @PostMapping("/up")
    public int up(@RequestBody PersonalReceiving id){
        int a = receivingService.xiugai(id);
        return a;
    }
}
