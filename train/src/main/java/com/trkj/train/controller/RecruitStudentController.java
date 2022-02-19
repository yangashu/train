package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.service.IRecruitStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("/recruit-student")
public class RecruitStudentController {
    @Autowired
    private IRecruitStudentService service;

    @GetMapping("/one")
    public int one(){
        return service.one().size();
    }

    @GetMapping("/two")
    public List<RecruitStudent> two(){
        List<RecruitStudent> list=service.one();
        List<RecruitStudent> list1=new ArrayList<>();
        for (RecruitStudent s : list){
            String newDate=new Date().toLocaleString();
            String oldDate=s.getStudentEntrance().toString();
            if(newDate.substring(0,7).equals(oldDate.substring(0,7))){
                list1.add(s);
            }
        }
        return list1;
    }

    //    学员中心   分页查询
    @GetMapping("/selectpage")
    public IPage<StudentDo> selectpage(@RequestParam("currentPage") int page, @RequestParam("size") int size){
        return service.selectpage(page, size);
    }
    //    学员中心 搜索直接查询
    @GetMapping("/selectipton")
    private IPage<StudentDo> selectipon(@RequestParam("page") int page,@RequestParam("size") int size,@RequestParam("value") String value,@RequestParam("input") String input,@RequestParam("downOne") String downOne,@RequestParam("checked") boolean checked,@RequestParam("deleted") int deleted){
        IPage<StudentDo> pagesas=service.selectipton(page, size, value, input, downOne, checked,deleted);
        return pagesas;
    }

//    学员中心  在读学员  编辑
    @PostMapping("updatestudent")
    public int updatestudent(@RequestBody RecruitStudent student){
        int updatestudents= service.updatestudent(student);
        return updatestudents;
    }

//    学员中心 在读学员 删除
    @PostMapping("delectstudent")
    public int delectstudent(@RequestBody RecruitStudent student){
        int delectstud= service.delectstudent(student);
        return delectstud;
    }

    //     班级管理   本班学员弹框内容查询
    @GetMapping("selectcxsy")
    public IPage<RecruitStudent> selectcx(@RequestParam("pageNum")int page,@RequestParam("pageSize")int size,@RequestParam("classid")int classid){
        return service.selectcx(page,size,classid);
    }

//    班级管理  本班学员弹框  搜索
    @GetMapping("selectiptionbb")
    public IPage<RecruitStudent> selectiptionbb(@RequestParam("pageNum")int page,@RequestParam("pageSize")int size,@RequestParam("classid")int classid,@RequestParam("input") String studentname){
        return service.selectbb(page, size, classid, studentname);
    }
}
