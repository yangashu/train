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

//    教程入库  新增教程 课程下拉框查询
    @GetMapping("selectjckc")
    public List<RecruitCourse> selectjckc(){
        return iCourseService.selectjckc();
    }

//    报名 课程查询搜索
    @GetMapping("selectkccx")
    public IPage<RecruitCourse> selectbmkc(@RequestParam("currentPage") int page,@RequestParam("size") int size,@RequestParam("kcmc") String kcmc){
        return iCourseService.selectbmkb(page, size, kcmc);
    }

//    报名  课程查询
    @GetMapping("selectkccxaa")
    public IPage<RecruitCourse> selectkcaa(@RequestParam("currentPage")int page,@RequestParam("size")int size){
        return iCourseService.selectkbcx(page, size);
    }

//    课程管理 添加课程
    @PostMapping("insertcourese")
    public int insertcourese(@RequestBody RecruitCourse recruitCourse){
        return iCourseService.insertkccoure(recruitCourse);
    }

    //    分页课程查询
    @GetMapping("/selectfycoure")
    public IPage<RecruitCourse> selectfycourse(@RequestParam("page") int page,@RequestParam("size") int size){
        return iCourseService.selectfycoure(page, size);
    }

//    课程刷新查询

}
