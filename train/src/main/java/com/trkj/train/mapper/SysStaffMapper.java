package com.trkj.train.mapper;

import com.trkj.train.entity.SysStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
public interface SysStaffMapper extends BaseMapper<SysStaff> {
    SysStaff findByid(@Param("id") int id);
}
