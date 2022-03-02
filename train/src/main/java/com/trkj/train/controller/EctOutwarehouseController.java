package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.TyVo.warehouseDo;
import com.trkj.train.entity.EctOutwarehouse;
import com.trkj.train.service.IEctOutwarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/ect-outwarehouse")
public class EctOutwarehouseController {
    @Autowired
    private IEctOutwarehouseService iEctOutwarehouseService;

    // 教程管理 教程出库表格查询
    @GetMapping("/selectwarehouse")
    public IPage<warehouseDo> selectwarehouse(@RequestParam("currentPageTwo") int page,@RequestParam("sizeTwo") int size,@RequestParam("shoushuokuanchuku") String shoushuokuanchuku,@RequestParam("deleted") int deleted){
        return iEctOutwarehouseService.selectwarehousedo(page, size, shoushuokuanchuku, deleted);
    }

    //    教程出库 添加
    @PostMapping("insertckjc")
    public int insertckjc(@RequestBody EctOutwarehouse ectOutwarehouse){
        return iEctOutwarehouseService.insertckjc(ectOutwarehouse);
    }

}
