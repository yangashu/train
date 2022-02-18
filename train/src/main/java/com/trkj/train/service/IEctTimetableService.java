package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.EctTimetableClassDo;
import com.trkj.train.TyVo.EctTimetablepkDo;
import com.trkj.train.entity.EctTimetable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctTimetableService extends IService<EctTimetable> {
//班级管理  本班课表弹框查询
    IPage<EctTimetableClassDo> selectiption(int page,int size,int classid);

    //    排课管理 查询
    IPage<EctTimetablepkDo> selectpk(int page,int size);

    //    排课管理 搜索
    IPage<EctTimetablepkDo> selectiptioncxpk(int page,int size,String classname,int deleted);

//    排课管理 删除
    int deletedpk(EctTimetable ectTimetable);
//    排课管理 添加
    int insertpk(EctTimetable ectTimetable);
}
