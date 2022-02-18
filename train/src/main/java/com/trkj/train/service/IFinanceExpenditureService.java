package com.trkj.train.service;

import com.trkj.train.config.Result;
import com.trkj.train.entity.FinanceExpenditure;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IFinanceExpenditureService extends IService<FinanceExpenditure> {

    Result paging(Map<String, Object> map);
}
