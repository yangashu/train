package com.trkj.train.service;

import com.trkj.train.config.Result;
import com.trkj.train.entity.SysPersonal;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ISysPersonalService extends IService<SysPersonal> {

    //修改头像
    int xiugai(SysPersonal sysPersonal);

}
