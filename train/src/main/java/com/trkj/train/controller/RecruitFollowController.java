package com.trkj.train.controller;


import com.trkj.train.entity.RecruitFollow;
import com.trkj.train.service.IRecruitFollowService;
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
@RequestMapping("/recruit-follow")
public class RecruitFollowController {
    @Autowired
    private IRecruitFollowService iRecruitFollowService;
    //    添加跟进
    @PostMapping("/insertgengjin")
    public int insertgengjin(@RequestBody RecruitFollow recruitFollow){
        return iRecruitFollowService.insertgengjin(recruitFollow);
    }

//    查询
    @GetMapping("/selectfollow")
    public List<RecruitFollow> selectfollow(@RequestParam("id") int id){
        return iRecruitFollowService.selectfollow(id);
    }
}
