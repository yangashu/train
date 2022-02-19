package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ClassesManageDO;
import com.trkj.train.config.Result;
import com.trkj.train.entity.EctClasses;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctClassesService extends IService<EctClasses> {
    //    分页
    Page<ClassesManageDO> selectClasses(ClassesManageDO classesManageDO, int page, int size);

    Result paging(Page<ClassesManageDO> page);

    int one();
    //    添加
    int inserclass(EctClasses classes);

    //    修改
    int updateclass(EctClasses classes);

    //   查询
    List<EctClasses> selectsyclass();

//    班级管理   搜索
    public IPage<ClassesManageDO> selectiptionclas(int page,int size,String input,String downOne,String downThree);

//    排课管理  添加弹框  班级下拉框查询
    List<EctClasses> selectipionbj();
}
