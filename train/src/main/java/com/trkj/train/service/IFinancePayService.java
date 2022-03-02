package com.trkj.train.service;

import com.trkj.train.entity.FinancePay;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IFinancePayService extends IService<FinancePay> {
//    添加
    int insertpay(FinancePay financePay);
}
