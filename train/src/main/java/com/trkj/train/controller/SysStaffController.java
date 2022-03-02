package com.trkj.train.controller;


import com.alibaba.fastjson.JSON;
import com.baidu.aip.util.Base64Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.trkj.train.entity.SysStaff;
import com.trkj.train.entity.vo.staffAndPersonal;
import com.trkj.train.service.ISysPersonalService;
import com.trkj.train.service.ISysStaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    //林文政分页
    @GetMapping("/two")
    public IPage<staffAndPersonal> two(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size){
        return service.two(page, size);
    }

    //模糊查询
    @GetMapping("five")
    public IPage<staffAndPersonal> five(@RequestParam("currentPage") int page,@RequestParam("pagesize") int size,@RequestParam("like") String like){
        return service.five(new Page(page,size),like);
    }

    //员工辞退方法
    @GetMapping("/three")
    public Result<?> three(@RequestParam("staffId") int staffId){
        int i= service.three(staffId);
        return Result.success(i);
    }

    //修改员工资料
    @PostMapping("/six")
    public Result<?> six(@RequestBody staffAndPersonal sap){
        int i=service.six(sap);
        return Result.success(i);
    }

    //员工恢复方法
    @GetMapping("/four")
    public Result<?> four(@RequestParam("staffId") int staffId){
        int i= service.four(staffId);
        return Result.success(i);
    }

    //林文政人脸分页
    @GetMapping("/faceOne")
    public IPage<staffAndPersonal> faceOne(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size){
        return service.selectFace(page, size);
    }

    //人脸更新
    @PostMapping("/facetwo/{id}")
    public Result facetwo(@PathVariable("id")int id, @RequestParam("url") MultipartFile url) throws Exception {
        return service.updateFace(id, Base64Util.encode(url.getBytes()));
    }

    //员工入职
    @PostMapping("/addStaff")
    public Result addStaff(@RequestBody SysStaff staff) throws IOException {
        return service.addStaff(staff);
    }

    //注测人脸
    @PostMapping("addUser")
    public Result addUser(MultipartFile url) throws Exception {
        return service.addUser(Base64Util.encode(url.getBytes()));
    }

    //修改员工密码
    @GetMapping("/updatePass")
    public Result updatePass(@RequestParam("staffId") int staffId,@RequestParam("oldPass") String oldPass,@RequestParam("newPass") String newPass){

        return service.updatePass(staffId,oldPass,newPass);
    }

    //查询员工系统账号
    @GetMapping("/selectStaffName")
    public Result selectName(){
        String maxStaffName= service.selectStaffName();
        return Result.success(maxStaffName);
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

    //教程入库  添加弹框 采购员下拉框查询
    @GetMapping("selectcgy")
    public List<SysStaff> selectcgy(){
        return service.selectcgy();
    }
}
