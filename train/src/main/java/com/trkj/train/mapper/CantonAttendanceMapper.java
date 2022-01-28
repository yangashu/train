package com.trkj.train.mapper;

import com.trkj.train.entity.CantonAttendance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
@Mapper
public interface CantonAttendanceMapper extends BaseMapper<CantonAttendance> {

    @Select("select * from attendance a WHERE TO_CHAR(a.ATTENDANCE_DATE,'yyyy-mm')=#{date} and a.STAFF_ID=#{staffId}")
    public List<CantonAttendance> one(@Param("date") String date, @Param("staffId") int staffId);

}
