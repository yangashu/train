package com.trkj.train.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPosition;
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
public interface ISysPositionService extends IService<SysPosition> {
    //    分页查询
    Result<?> selectpage(Page<SysPosition> sysPositionPage, String keyword);

    Result<?> findByid(int id);

    Result deleteById(int id);

    Result deleteBatchIds(List<Integer> ids);


}
