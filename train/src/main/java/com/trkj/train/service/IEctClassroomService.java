package com.trkj.train.service;

import com.trkj.train.entity.EctClassroom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.mapper.EctClassroomMapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface IEctClassroomService extends IService<EctClassroom> {
    //    查询未用的所有教室
    List<EctClassroom> selectclassrom();
    //    修改教室状态
    int updateclassrom(EctClassroom classroom);
//    查询所有教室的名字
    List<EctClassroom> selectsyroom();
}
