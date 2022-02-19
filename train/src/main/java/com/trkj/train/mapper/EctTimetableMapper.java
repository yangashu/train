package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.EctTimetableClassDo;
import com.trkj.train.TyVo.EctTimetablepkDo;
import com.trkj.train.TyVo.StudentDo;
import com.trkj.train.entity.EctTimetable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface EctTimetableMapper extends BaseMapper<EctTimetable> {
//班级管理  本班课表弹框查询
    IPage<EctTimetableClassDo> selectiptionkb(Page page,@Param("classid") int classid);

//    排课管理 查询
    IPage<EctTimetablepkDo> selectkcxkb(Page<EctTimetablepkDo> page);

//    排课管理 搜索
    IPage<EctTimetablepkDo> selectiptionkbcx(Page page,@Param(Constants.WRAPPER) QueryWrapper<EctTimetablepkDo> consultationDOQueryWrapper);
}
