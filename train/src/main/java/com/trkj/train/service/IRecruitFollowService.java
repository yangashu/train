package com.trkj.train.service;

import com.trkj.train.entity.RecruitFollow;
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
public interface IRecruitFollowService extends IService<RecruitFollow> {

    public List<RecruitFollow> one();
}
