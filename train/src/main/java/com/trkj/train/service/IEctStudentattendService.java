package com.trkj.train.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.EctStudentattend;
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
public interface IEctStudentattendService extends IService<EctStudentattend> {

    public List<EctStudentattend> one(QueryWrapper<EctStudentattend> queryWrapper);
}
