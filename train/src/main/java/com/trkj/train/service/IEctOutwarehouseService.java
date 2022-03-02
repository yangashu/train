package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.warehouseDo;
import com.trkj.train.entity.EctOutwarehouse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctOutwarehouseService extends IService<EctOutwarehouse> {
// 教程管理 教程出库表格查询
    IPage<warehouseDo> selectwarehousedo(int page,int size,String shoushuokuanchuku,int deleted);

//    教程出库 添加
    int insertckjc(EctOutwarehouse ectOutwarehouse);
}
