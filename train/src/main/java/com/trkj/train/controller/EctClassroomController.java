package com.trkj.train.controller;


import com.trkj.train.entity.EctClassroom;
import com.trkj.train.service.IEctClassroomService;
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
@RequestMapping("/ect-classroom")
public class EctClassroomController {
    @Autowired
    private IEctClassroomService iClassroomService;
    //    查询未用的所有教室
    @GetMapping("/selectclassrom")
    public List<EctClassroom> selectclassroom(){
        return iClassroomService.selectclassrom();
    }
    //    修改教室状态
    @PostMapping("/updateclassrom")
    public int updateclassrom(@RequestBody EctClassroom classroom){
        return iClassroomService.updateclassrom(classroom);
    }
//    查询所有教室
    @GetMapping("/selectsyclassroom")
    public List<EctClassroom> selectsyroom(){
        return iClassroomService.selectsyroom();
    }
}
