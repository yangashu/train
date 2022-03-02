package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.EctWarehouse;
import com.trkj.train.service.IEctWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/ect-warehouse")
public class EctWarehouseController {
    @Autowired
    private IEctWarehouseService iEctWarehouseService;

    @PostMapping("insertkccktable")
    public int insertkccktable(@RequestBody EctWarehouse ectWarehouse){
        return iEctWarehouseService.insertckkctable(ectWarehouse);
    }

    //    教程管理  追加库存  修改仓库表
    @PostMapping("updatekcck")
    public int updatekcck(@RequestBody EctWarehouse ectWarehouse){
        return iEctWarehouseService.updatejcck(ectWarehouse);
    }

    // 查询仓库中数量大于0的教材
    @GetMapping("selectNamejc")
    public List<EctWarehouse> selectNameJc(){
        return iEctWarehouseService.selectNamejc();
    }

    //    教程出库 修改库存数量
    @PostMapping("updateckNumber")
    public int updatekcNumber(@RequestBody EctWarehouse ectWarehouse){
        return iEctWarehouseService.updatekcNumber(ectWarehouse);
    }

    //    仓库查询 表格查询
    @GetMapping("selectckcxaa")
    public IPage<EctWarehouse> selectckcx(@RequestParam("currentPageckOne") int page,@RequestParam("sizeckOne") int size,@RequestParam("deleted") int deleted,@RequestParam("ckshoushuokuan") String  ckshoushuokuan){
        return iEctWarehouseService.selectckcx(page, size, deleted, ckshoushuokuan);
    }
}
