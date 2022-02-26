package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.CantonStaffleave;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.entity.vo.staffAndPersonalAndLeave;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ICantonStaffleaveService extends IService<CantonStaffleave> {

    public IPage<staffAndPersonalAndLeave> selectLeaveAll(Page page,String like);

}
