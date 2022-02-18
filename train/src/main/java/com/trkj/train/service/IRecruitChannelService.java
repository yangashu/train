package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.RecruitChannel;
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
public interface IRecruitChannelService extends IService<RecruitChannel> {
    //    分页
    IPage<RecruitChannel> page(int page, int size);
    //    新增渠道
    int addqudao(RecruitChannel channel);
    //    修改渠道
    int updatequdao(RecruitChannel channel);
    //    根据渠道名称分页查询
    IPage<RecruitChannel> likeselect(int page,int size,String channelName);
    //    删除
    int delectchannel(RecruitChannel channel);
}
