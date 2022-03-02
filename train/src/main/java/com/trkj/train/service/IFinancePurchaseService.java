package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.FinancePurchase;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IFinancePurchaseService extends IService<FinancePurchase> {
//教程入库查询
//    IPage<FinancePurchaseDo> selectcgjc(int page,int size);

    //    教程入库搜索查询
//    IPage<FinancePurchaseDo> selectiptionjc(int page,int size,int deleted,String shoushuokuan);

//    教程入库 添加
    int insertjcrk(FinancePurchase financePurchase);

//    教程入库  编辑
    int updatejcrk(FinancePurchase financePurchase);
}
