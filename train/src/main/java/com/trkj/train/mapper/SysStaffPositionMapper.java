package com.trkj.train.mapper;

import com.trkj.train.entity.SysPosition;
import com.trkj.train.entity.SysStaffPosition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface SysStaffPositionMapper extends BaseMapper<SysStaffPosition> {

    public boolean insertBatch(@Param("list") List<SysStaffPosition> staffPosition);

    public List<SysPosition> selectBystaffid(@Param("staffid") int staffid);

    boolean deleteByStaffId(int staffId);

}
