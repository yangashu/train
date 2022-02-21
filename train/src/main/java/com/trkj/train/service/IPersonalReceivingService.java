package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.ReceivingView;
import com.trkj.train.entity.PersonalReceiving;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IPersonalReceivingService extends IService<PersonalReceiving> {
    public int one(int staffId);

    //分页查询
    IPage<ReceivingView> receiving(int page, int size, int id);
    //模糊查询
    public IPage<ReceivingView> lickselect(int page, int size, String like, int id);
    //逻辑删除
    int dele(int id);
    //修改状态
    int xiugai(PersonalReceiving id);
}
