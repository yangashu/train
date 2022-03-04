package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysDept;
import com.trkj.train.entity.SysPosition;
import com.trkj.train.service.ISysDeptService;
import com.trkj.train.service.ISysPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/sys-position")
public class SysPositionController {
    @Autowired
    private ISysPositionService service;
    @Autowired
    private ISysDeptService iDeptService;
    //    分页查询
    @PreAuthorize("hasAnyAuthority('sys:role','sys:role:list','sys:manage','sing')")
    @GetMapping("/paging")
    public Result<?> paging(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "1") int size, @RequestParam(defaultValue = "") String keyword) {

        return service.selectpage(new Page<SysPosition>(page,size),keyword);

    }
    //    根据id查询
    @GetMapping("/findByid")
    public Result<?> findByid(int id){
       return service.findByid(id);

    }
    @PreAuthorize("hasAnyAuthority('sys:role','sys:role:del','sys:manage')")
    //    根据id删除
    @DeleteMapping("/deleteByid")
    public Result<?> deleteByid(@RequestParam int id) {

            return service.deleteById(id);
    }

    //    批量删除
    @PreAuthorize("hasAnyAuthority('sys:role','sys:role:del','sys:manage')")
    @PostMapping("/deleteBatchIds")
    public Result<?> deleteBatchIds(@RequestBody List<Integer> ids) {
        return service.deleteBatchIds(ids);
    }

    //    添加
    @PreAuthorize("hasAnyAuthority('sys:role','sys:role:insert','sys:manage')")
    @PostMapping("/insert")
    public Result<?> insert(@RequestBody SysPosition position) {
        boolean x = service.save(position);
        if (x) {
            return Result.success("0","添加成功！！！",null);
        } else
            return Result.error("-1", "添加失败！！！");
    }
    //    修改
    @PreAuthorize("hasAnyAuthority('sys:role','sys:role:edit','sys:manage')")
    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('sss')")
    public Result<?> update(@RequestBody SysPosition position) {
        boolean x = service.updateById(position);
        if (x) {
            return Result.success("0","修改成功！！！",null);
        } else
            return Result.error("-1", "操作失败！！！");
    }
}
