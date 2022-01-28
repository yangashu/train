package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.CantonSatffsign;
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
public interface ICantonSatffsignService extends IService<CantonSatffsign> {

    public IPage<staffAndSign> one(int page, int size);

    public int two(int userId);

    public CantonSatffsign three(int staffID);
}
