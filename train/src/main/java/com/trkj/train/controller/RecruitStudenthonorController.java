package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.recruitStudentHonorDo;
import com.trkj.train.entity.RecruitStudenthonor;
import com.trkj.train.service.IRecruitStudenthonorService;
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
@RequestMapping("/recruit-studenthonor")
public class RecruitStudenthonorController {
    @Autowired
    private IRecruitStudenthonorService iRecruitStudenthonorService;

//    学员中心 详情弹框  学员荣誉查询
    @GetMapping("/selectstudentry")
    public IPage<recruitStudentHonorDo> selectstudentry(@RequestParam("honorcurrentPage")  int page,@RequestParam("honorsize") int size,@RequestParam("studentId") int studentId){
        return iRecruitStudenthonorService.selectxyry(page, size, studentId);
    }

//    学员中心 详情弹框  学员荣誉添加
    @PostMapping("insertstudentry")
    public int insertstudentry(@RequestBody RecruitStudenthonor recruitStudenthonor){
        return iRecruitStudenthonorService.insertstudentry(recruitStudenthonor);
    }

}
