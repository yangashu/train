package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.service.ISysPersonalService;
import com.trkj.train.service.ISysStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
@RestController
@RequestMapping("/sys-staff")
public class SysStaffController {
    @Autowired
    private ISysStaffService service;

    @GetMapping("/one")
    public List<SysStaff> one(){
        return service.list();
    }



    //    系统管理下的用户管理
    @GetMapping("/paging")
    public Result<?> paging(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "") String search){
        IPage<SysStaff> list=service.paging(new Page<SysStaff>(page,size),search);
        return Result.success(list);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Map<String,Object> map){

        return service.insert(map);
    }

    @GetMapping("findByid")
    public Result findByid(@RequestParam("id") int id){
        return service.findByid(id);
    }

    //    根据id删除
    @DeleteMapping("/deleteByid")
    public Result<?> deleteByid(@RequestParam int id) {

        return service.deleteById(id);
    }

    //    批量删除
    @PostMapping("/deleteBatchIds")
    public Result<?> deleteBatchIds(@RequestBody List<Integer> ids) {
        return service.deleteBatchIds(ids);
    }

    // 班级管理   添加班级弹框  班主任下拉框   查询为班主任的员工名字
    @GetMapping("/selectteacher")
    public List<SysStaff> selectteacher(){
        return service.insertstaff();
    }
    //  咨询登记  跟进人下拉框  查询为咨询师的员工名字
    @GetMapping("selectgjr")
    public List<SysStaff> selectgjr(){
        return service.selectgjr();
    }
    //    学员中心   在读学员   上课老师下拉框查询
    @GetMapping("selectclassteacher")
    public List<SysStaff> selectclassteacher(){
        return service.selectclassteacher();
    }
}
