package com.trkj.train.controller;


import com.trkj.train.entity.RecruitFollow;
import com.trkj.train.service.IRecruitFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.trkj.train.entity.RecruitFollow;
import com.trkj.train.service.IRecruitFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@RequestMapping("/recruit-follow")
public class RecruitFollowController {
    @Autowired
    private IRecruitFollowService service;

    @PostMapping("/one")
    public List<RecruitFollow> one(){
        return service.one();
    }

    //    添加跟进
    @PostMapping("/insertgengjin")
    @PreAuthorize("hasAnyAuthority('recruit:counsulting','recruit:counsulting:addgjr','sys:manage')")
    public int insertgengjin(@RequestBody RecruitFollow recruitFollow){
        return service.insertgengjin(recruitFollow);
    }

//    查询
    @GetMapping("/selectfollow")
    public List<RecruitFollow> selectfollow(@RequestParam("id") int id){
        return service.selectfollow(id);
    }
}
