package com.trkj.train.controller;


import com.trkj.train.service.IEctClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ClassesManageDO;
import com.trkj.train.config.Result;
import com.trkj.train.entity.EctClasses;
import com.trkj.train.service.IEctClassesService;
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
@RequestMapping("/ect-classes")
public class EctClassesController {
    @Autowired
    private IEctClassesService classesService;

    @GetMapping("/one")
    public int one(){
        return classesService.one();
    }

    //分页查询
    @PostMapping("/query")
    public Result<Page<ClassesManageDO>> query(@RequestBody ClassesManageDO classesManageDO,
                                               @RequestParam(defaultValue = "2") int pageSize, @RequestParam(defaultValue = "1") int pageNum){
        Page<ClassesManageDO> page = classesService.selectClasses(classesManageDO,pageNum, pageSize);
        return Result.success(page);
    }
    //分页查询
    @GetMapping("/a")
    public Result a(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "2") int pageSize){

        return classesService.paging(new Page<ClassesManageDO>(pageNum,pageSize));
    }

    //    @GetMapping("/selectsy")
//    public List<ClassesManageDO> selectsy(){
//        List<ClassesManageDO> list=classesService.selectCl();
//        return list;
//    }
//    添加方法
    @PostMapping("/insertclass")
    public int insertsy(@RequestBody EctClasses classes){
        return classesService.inserclass(classes);
    }
    //    修改方法
    @PostMapping("updateclass")
    public int updateclass(@RequestBody EctClasses classes){
        return classesService.updateclass(classes);
    }
    //    查询方法
    @GetMapping("/selectsyclass")
    public List<EctClasses> selectsyclass(){
        return classesService.selectsyclass();
    }
//    班级管理    搜索
    @GetMapping("/selectiptionclass")
    public IPage<ClassesManageDO> selectiption(@RequestParam("pageNum") int page,@RequestParam("pageSize") int size,@RequestParam("input") String input,@RequestParam("downThree") String downThree,@RequestParam("downOne") String downOne){
        System.out.println("page"+page);
        System.out.println("size"+size);
        IPage<ClassesManageDO> pagessa=classesService.selectiptionclas(page, size, input, downThree, downOne);
        return pagessa;
    }
    //    排课管理  添加弹框  班级下拉框查询
    @GetMapping("/selectpkclass")
    public List<EctClasses> selectiptionclass(){
        return classesService.selectipionbj();
    }
}
