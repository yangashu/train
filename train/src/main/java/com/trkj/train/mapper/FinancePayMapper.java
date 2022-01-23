package com.trkj.train.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.FinancePay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface FinancePayMapper extends BaseMapper<FinancePay> {

    int saveAll(FinancePay item);
}
