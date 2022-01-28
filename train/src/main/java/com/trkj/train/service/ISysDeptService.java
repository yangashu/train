package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.entity.vo.staffAndDept;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ISysDeptService extends IService<SysDept> {

    public IPage<staffAndDept> one(int page, int size);

    public List<SysDept> three();

    public Result two(String deptName);

    public Result four(int id,String deptName);

    public Result five(int id);

    public IPage<staffAndDept> six(Page page, String deptName);
}
