package com.trkj.train.controller;


import com.trkj.train.entity.RecruitStudent;
import com.trkj.train.service.IRecruitStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@RequestMapping("/recruit-student")
public class RecruitStudentController {

    @Autowired
    private IRecruitStudentService service;

    @GetMapping("/one")
    public int one(){
        return service.one().size();
    }

    @GetMapping("/two")
    public List<RecruitStudent> two(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
        List<RecruitStudent> list=service.one();
        List<RecruitStudent> list1=new ArrayList<>();
        for (RecruitStudent s : list){
            String newDate=format.format(new Date());
            String oldDate=format.format(s.getStudentEntrance());
            if(newDate.equals(oldDate)){
                list1.add(s);
            }
        }
        return list1;
    }
}
