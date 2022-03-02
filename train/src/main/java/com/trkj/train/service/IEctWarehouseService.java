package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.EctInwarehouse;
import com.trkj.train.entity.EctWarehouse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctWarehouseService extends IService<EctWarehouse> {
// 教程管理 添加仓库表
    int insertckkctable(EctWarehouse ectWarehouse);

//    教程管理  追加库存  修改仓库表
    int updatejcck(EctWarehouse ectWarehouse);

    // 查询仓库中数量大于0的教材
    List<EctWarehouse> selectNamejc();

    //    教程出库 修改库存数量
    int updatekcNumber(EctWarehouse ectWarehouse);

//    仓库查询 表格查询
    IPage<EctWarehouse> selectckcx(int page,int size,int deleted,String ckshoushuokuan);
}
