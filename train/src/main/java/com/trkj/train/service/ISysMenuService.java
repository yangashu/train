package com.trkj.train.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface ISysMenuService extends IService<SysMenu> {
    public IPage<SysMenu> pageing(int size, int page, String keyword);
    public int deelteByid(int id);
}
