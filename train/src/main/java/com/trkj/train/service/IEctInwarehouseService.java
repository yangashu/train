package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.FinancePurchaseDo;
import com.trkj.train.entity.EctInwarehouse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctInwarehouseService extends IService<EctInwarehouse> {
//  教程管理  添加入库表
    int insertrkjc(EctInwarehouse ectInwarehouse);

    //    教程入库搜索查询
    IPage<FinancePurchaseDo> selectiptionjc(int page, int size, int deleted, String shoushuokuan);
}
