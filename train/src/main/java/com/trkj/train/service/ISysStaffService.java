package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysStaff;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.entity.vo.staffAndPersonal;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
public interface ISysStaffService extends IService<SysStaff> {
    public IPage<SysStaff> paging(Page<SysStaff> page, String search);

    Result insert(Map<String, Object> map);

    Result findByid(int id);

    Result<?> deleteBatchIds(List<Integer> ids);

    Result<?> deleteById(int id);

    public IPage<staffAndPersonal> two(int page, int size);

    public IPage<staffAndPersonal> five(Page page,String like);

    public int three(int staffId);

    public int six(staffAndPersonal sap);

    public int four(int staffId);
}
