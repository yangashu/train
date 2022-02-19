package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.trkj.train.entity.EctClassroom;
import com.trkj.train.mapper.EctClassroomMapper;
import com.trkj.train.service.IEctClassroomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class EctClassroomServiceImpl extends ServiceImpl<EctClassroomMapper, EctClassroom> implements IEctClassroomService {
    @Autowired
    private EctClassroomMapper classroomMapper;

    //    查询未用的所有教室
    @Override
    public List<EctClassroom> selectclassrom() {
        return classroomMapper.selectList(new LambdaQueryWrapper<EctClassroom>().eq(EctClassroom::getCalssroomState,0));
    }
    //    修改教室状态
    @Override
    public int updateclassrom(EctClassroom classroom) {
        System.out.println("ghfghfhg"+classroom.toString());
        return classroomMapper.updateById(classroom);
    }

    @Override
    public List<EctClassroom> selectsyroom() {
        return classroomMapper.selectsyroom();
    }
}
