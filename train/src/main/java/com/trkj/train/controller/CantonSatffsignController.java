package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.CantonSatffsign;
import com.trkj.train.entity.vo.staffAndSign;
import com.trkj.train.service.ICantonSatffsignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/canton-satffsign")
public class CantonSatffsignController {
    @Autowired
    private ICantonSatffsignService service;

    //工作台查询今日打卡
    @GetMapping("/one")
    public int one(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        List<CantonSatffsign> list=service.list();
        int rs= list.size();
        for(CantonSatffsign s: list){
            String newDate=format.format(new Date());
            String oldDate=format.format(s.getSignDate());
            if(newDate.equals(oldDate)){
                continue;
            }else{
                s.setSignState(0);
                rs=rs-1;
            }
        }
        return rs;
    }

    //员工考勤分页
    @GetMapping("/two")
    public IPage<staffAndSign> two(@RequestParam("currentPage")int page, @RequestParam("pagesize")int size){
        return service.one(page, size);
    }

}
