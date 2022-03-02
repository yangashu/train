package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.punishDo;
import com.trkj.train.entity.RecruitStundentpunish;
import com.trkj.train.service.IRecruitStundentpunishService;
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
@RequestMapping("/recruit-stundentpunish")
public class RecruitStundentpunishController {
    @Autowired
    private IRecruitStundentpunishService iRecruitStundentpunishService;

//    查询处分表
    @GetMapping("/selectpushin")
    public IPage<punishDo> selectpushin(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("studentId") int studentId){
        return iRecruitStundentpunishService.selectpunish(page, size, studentId);
    }

//    添加处分表
    @PostMapping("/insertpushin")
    public int insertpushin(@RequestBody RecruitStundentpunish recruitStundentpunish){
        return iRecruitStundentpunishService.insertpunish(recruitStundentpunish);
    }

}
