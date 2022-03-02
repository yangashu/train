package com.trkj.train.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.TyVo.ConsultationDo;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.FinancePurchase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface FinancePurchaseMapper extends BaseMapper<FinancePurchase> {
//教程入库查询
//    IPage<FinancePurchaseDo> selectcgjc(Page<FinancePurchaseDo> page);
//    教程入库搜索查询
//    IPage<FinancePurchaseDo> selectiptionss(Page<FinancePurchaseDo> page, @Param(Constants.WRAPPER) QueryWrapper<FinancePurchaseDo> consultationDOQueryWrapper);
}
