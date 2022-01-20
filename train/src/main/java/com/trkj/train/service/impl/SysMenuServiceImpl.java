package com.trkj.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.train.entity.SysMenu;
import com.trkj.train.mapper.SysMenuMapper;
import com.trkj.train.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    private SysMenuMapper mapper;
    @Override
    public IPage<SysMenu> pageing(int size, int page, String keyword) {
        QueryWrapper<SysMenu> wrapper=new QueryWrapper();
        wrapper.eq("menu_pid",0);
        wrapper.like("menu_name",keyword);
        return mapper.selectPage(new Page<>(size,page),wrapper);
    }

    @Override
    public int deelteByid(int id) {
        return mapper.deleteById(id);
    }
}
