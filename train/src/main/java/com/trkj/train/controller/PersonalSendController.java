package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.SendView;
import com.trkj.train.entity.PersonalSend;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.service.impl.PersonalSendServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/personal-send")
public class PersonalSendController {

    @Autowired
    private PersonalSendServiceImpl sendService;

    @GetMapping("/shoujian")
    public IPage<SendView> shoujian(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("id") int id){
        IPage<SendView> sendIPage = sendService.SelectPage(page, size, id);
        return sendIPage;
    }

    @GetMapping("/like")
    public IPage<SendView> Like(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("like") String like, @RequestParam("id") int id){
        IPage<SendView> iPage= sendService.lickselect(page, size,like,id);
        return iPage;
    }

    @GetMapping("/selectlist")
    public List<SysStaff> selectlist(){
        return sendService.selectcheckd();
    }

    @PostMapping("/addsend")
    public int addsend(@RequestBody PersonalSend send){
        int a=sendService.adds(send);
        return a;
    }

    @PostMapping("/del")
    public int del(@RequestBody PersonalSend send){
        int a = sendService.delete(send.getSendId());
        return a;
    }
    //草稿箱发件
    @PostMapping("/ad")
    public int ad(@RequestBody PersonalSend send){
        int a=sendService.ad(send);
        return a;
    }
}
