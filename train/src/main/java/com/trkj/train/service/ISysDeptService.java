package com.trkj.train.service;

import com.trkj.train.entity.SysDept;
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
public interface ISysDeptService extends IService<SysDept> {
    public List<SysDept> selectDeptList();
}
