package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.EctTimetableClassDo;
import com.trkj.train.TyVo.EctTimetablepkDo;
import com.trkj.train.entity.EctTimetable;
import com.trkj.train.service.IEctClassroomService;
import com.trkj.train.service.IEctTimetableService;
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
@RequestMapping("/ect-timetable")
public class EctTimetableController {
    @Autowired
    private IEctTimetableService iEctTimetableService;
//    班级管理  本班课表弹框查询
    @GetMapping("selectiptionkb")
    public IPage<EctTimetableClassDo> selectiptionkeb(@RequestParam("schedulecurrentPageOne") int page,@RequestParam("schedulesizeOne") int size,@RequestParam("classid") int classid){
        return iEctTimetableService.selectiption(page, size, classid);
    }

    //    排课管理 查询
    @GetMapping("selectkb")
    public IPage<EctTimetablepkDo> selectpk(@RequestParam("currentPage")int page,@RequestParam("size") int size){
        return iEctTimetableService.selectpk(page, size);
    }

    //    排课管理 搜索
    @GetMapping("selectss")
    public IPage<EctTimetablepkDo> selectss(@RequestParam("currentPage") int page,@RequestParam("size") int size,@RequestParam("classname") String classname,@RequestParam("deleted") int deleted){
        return iEctTimetableService.selectiptioncxpk(page, size, classname, deleted);
    }

//    排课管理  删除
    @PostMapping("deletedpk")
    public int delectpk(@RequestBody EctTimetable ectTimetable){
        return iEctTimetableService.deletedpk(ectTimetable);
    }

//    排课管理 添加
    @PostMapping("insertpk")
    public int insertpk(@RequestBody EctTimetable ectTimetable){
        return iEctTimetableService.insertpk(ectTimetable);
    }
}
