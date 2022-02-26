package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.vo.staffAndDept;
import com.trkj.train.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/sys-dept")
public class SysDeptController {
    @Autowired
    private ISysDeptService service;

    //查询全部部门
    @GetMapping("/list")
    public Result list(){
        return Result.success(service.selectDeptList());
    }

    //分页查询方法
    @GetMapping("/one")
    public IPage<staffAndDept> one(@RequestParam("currentPage") int page, @RequestParam("pagesize") int size){
        return service.one(page, size);
    }
    //添加方法
    @GetMapping("/two")
    public Result two(@RequestParam("deptName") String deptName,@RequestParam("deptParentid")int deptPanentid){
        return service.two(deptName,deptPanentid);
    }
    //修改方法
    @GetMapping("/three")
    public Result three(@RequestParam("id")int id,@RequestParam("deptName")String deptName,@RequestParam("deptParentid")int deptPanentid){
        return service.four(id,deptName,deptPanentid);
    }
    //删除方法
    @GetMapping("/four")
    public Result four(@RequestParam("id")int id){
        return service.five(id);
    }

    //模糊查询方法
    @GetMapping("/five")
    public IPage<staffAndDept> five(@RequestParam("currentPage") int page,@RequestParam("pagesize") int size,@RequestParam("like")String deptName){
        return service.six(new Page(page,size),deptName);
    }
}
