package com.trkj.train.service;

import com.trkj.train.entity.EctTransferrecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctTransferrecordService extends IService<EctTransferrecord> {
    // 添加
    int insertZhuanban(EctTransferrecord ectTransferrecord);

}
