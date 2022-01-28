package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.train.entity.vo.staffAndSign;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ISysPersonalService extends IService<SysPersonal> {

    public SysPersonal one(int staffId);

    public IPage<staffAndSign> two(String information, String mode, int page, int size);
}
