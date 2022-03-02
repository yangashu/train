package com.trkj.train.service;

import com.trkj.train.entity.EctRefund;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctRefundService extends IService<EctRefund> {
//添加退费表
    int inserttuifei(EctRefund ectRefund);
}
