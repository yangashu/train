package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.RecruitCourse;
import com.trkj.train.service.IRecruitCourseService;
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
@RequestMapping("/recruit-course")
public class RecruitCourseController {
    @Autowired
    private IRecruitCourseService iCourseService;
    //查询所有课程
    @GetMapping("/selectkechen")
        public List<RecruitCourse> selectkechen(){
        return iCourseService.selectkec();
    }
//    课程管理  编辑
    @PostMapping("updatekc")
    public int updatekc( @RequestBody RecruitCourse recruitCourse){
        System.out.println(recruitCourse);
        return iCourseService.editbjkc(recruitCourse);
    }
}
