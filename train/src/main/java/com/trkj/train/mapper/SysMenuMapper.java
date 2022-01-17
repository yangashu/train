package com.trkj.train.mapper;

import com.trkj.train.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    public List<String> selectPermsByStaffId(int staffid);
}
