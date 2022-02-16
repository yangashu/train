package com.trkj.train.mapper;

import com.trkj.train.entity.SysStaff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-18
 */
@Mapper
public interface SysStaffMapper extends BaseMapper<SysStaff> {
    SysStaff findByid(@Param("id") int id);

    @Select("select max(staff_name) from sys_staff")
    public String selectNameMax();
}
