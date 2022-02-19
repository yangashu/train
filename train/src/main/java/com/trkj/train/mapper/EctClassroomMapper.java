package com.trkj.train.mapper;

import com.trkj.train.entity.EctClassroom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
public interface EctClassroomMapper extends BaseMapper<EctClassroom> {
    @Select("SELECT * FROM ECT_CLASSROOM")
List<EctClassroom> selectsyroom();
}
