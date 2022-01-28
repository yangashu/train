package com.trkj.train.service;

import com.trkj.train.entity.CantonAttendance;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ICantonAttendanceService extends IService<CantonAttendance> {
    public int one(int userId);

    public List<CantonAttendance> two(int staffId);

    public List<CantonAttendance> three(String date,int staffId);

}
