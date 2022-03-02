package com.trkj.train.mapper;

import com.trkj.train.entity.EctWarehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface EctWarehouseMapper extends BaseMapper<EctWarehouse> {
// 查询仓库中数量大于0的教材
    @Select("SELECT * FROM ect_warehouse w WHERE w.warehouse_number>0 and w.DELETED=0")
    List<EctWarehouse> selectNameck();

//    教程出库 修改库存数量
    @Update("UPDATE ect_warehouse set warehouse_number=#{warehouseNumber} where warehouse_id=#{warehouseId}")
    int updateckNumber(EctWarehouse ectWarehouse);
}
