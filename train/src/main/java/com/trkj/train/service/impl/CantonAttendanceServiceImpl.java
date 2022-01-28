package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.train.entity.CantonAttendance;
import com.trkj.train.mapper.CantonAttendanceMapper;
import com.trkj.train.service.ICantonAttendanceService;
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
public class CantonAttendanceServiceImpl extends ServiceImpl<CantonAttendanceMapper, CantonAttendance> implements ICantonAttendanceService {

    @Autowired
    private CantonAttendanceMapper mapper;

    @Override
    public int one(int userId) {
        CantonAttendance attendance=new CantonAttendance();
        attendance.setStaffId(userId);
        return mapper.insert(attendance);
    }

    @Override
    public List<CantonAttendance> two(int staffId) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("STAFF_ID",staffId);
        return mapper.selectList(queryWrapper);
    }

    @Override
    public List<CantonAttendance> three(String date, int staffId) {
        date="2021-12";
        staffId=3;
        return mapper.one(date, staffId);
    }
}
