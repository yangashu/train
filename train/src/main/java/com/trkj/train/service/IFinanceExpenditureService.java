package com.trkj.train.service;

import com.trkj.train.entity.FinanceExpenditure;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IFinanceExpenditureService extends IService<FinanceExpenditure> {
//    教程管理  新增教程  支出表添加
    int insertzckc(FinanceExpenditure financeExpenditure);

}
