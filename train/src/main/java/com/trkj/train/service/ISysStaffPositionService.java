package com.trkj.train.service;

import com.trkj.train.config.Result;
import com.trkj.train.entity.SysStaffPosition;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ISysStaffPositionService extends IService<SysStaffPosition> {

    Result<?> position(int id);

    Result perm(int userId, int[] roleIds);
}
