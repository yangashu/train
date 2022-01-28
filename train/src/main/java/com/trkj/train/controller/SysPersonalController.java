package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.Result;
import com.trkj.train.entity.vo.staffAndSign;
import com.trkj.train.service.ISysPersonalService;
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
@RequestMapping("/sys-personal")
public class SysPersonalController {

    @Autowired
    private ISysPersonalService iPersonalService;

    @GetMapping("/one")
    public IPage<staffAndSign> one(@RequestParam("information") String information, @RequestParam("mode") String mode, @RequestParam("mycurrentPage") int page, @RequestParam("mypagesize") int size){
        return  iPersonalService.two(information,mode,page,size);
    }
}
