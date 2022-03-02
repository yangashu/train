package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.TalkeDo;
import com.trkj.train.entity.RecruitStudenttalk;
import com.trkj.train.service.IRecruitStudenttalkService;
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
@RequestMapping("/recruit-studenttalk")
public class RecruitStudenttalkController {
    @Autowired
    private IRecruitStudenttalkService iRecruitStudenttalkService;

    // 学员谈话表查询
    @GetMapping("selecttalk")
    public IPage<TalkeDo> selecttalk(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("studentId") int studentId){
        return iRecruitStudenttalkService.selecttalk(page, size, studentId);
    }

//    添加
    @PostMapping("/inserttalk")
    public int inserttakl(@RequestBody RecruitStudenttalk recruitStudenttalk){
        return iRecruitStudenttalkService.inserttalk(recruitStudenttalk);
    }

//    删除
    @PostMapping("/deletedtalk")
    public int deletedtakl(@RequestBody RecruitStudenttalk recruitStudenttalk){
        return iRecruitStudenttalkService.deletetalk(recruitStudenttalk);
    }

}
